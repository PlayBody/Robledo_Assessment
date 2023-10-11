package robledo.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import robledo.home.demo.response.MessageResponse;
import robledo.home.demo.model.Customer;
import robledo.home.demo.model.RewardPoints;
import robledo.home.demo.model.Transaction;
import robledo.home.demo.repository.TransactionRepository;

import java.util.*;

@Service
public class RewardService {

    @Autowired
    public TransactionRepository transactionRepository;

    public ResponseEntity<?> calculatePoints(Customer customer) {

        List<Transaction> transactions = transactionRepository.findByCustomerId(customer.getId()).orElse(null);

        Map<String, Integer> pointsByMonth = new HashMap<>();
        int totalPoints = 0;

        if(transactions != null) {
            for (Transaction tx : transactions) {
                int points = calculateTransactionPoints(tx);
                totalPoints += points;

                String month = getMonth(tx.getDate());
                pointsByMonth.put(month, pointsByMonth.getOrDefault(month, 0) + points);
            }

            List<RewardPoints> rewards = getRewardPoints(customer, totalPoints, pointsByMonth);

            return ResponseEntity.ok()
                    .body(rewards);
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Transaction not exist!"));
        }
    }

    private static List<RewardPoints> getRewardPoints(Customer customer, int totalPoints, Map<String, Integer> pointsByMonth) {
        List<RewardPoints> rewards = new ArrayList<>();
        RewardPoints reward = new RewardPoints();

        reward.setCustomerId(customer.getId());
        reward.setCustomer(customer.getName());
        reward.setTotalPoints(totalPoints);

        List<RewardPoints.PointsPerMonth> pointsPerMonths = new ArrayList<>();

        for (Map.Entry<String, Integer> Entry : pointsByMonth.entrySet()) {
            RewardPoints.PointsPerMonth pointsPerMonth = new RewardPoints.PointsPerMonth();

            pointsPerMonth.setMonth(Entry.getKey());
            pointsPerMonth.setPoints(Entry.getValue());

            pointsPerMonths.add(pointsPerMonth);
        }
        reward.setPointsPerMonths(pointsPerMonths);

        rewards.add(reward);
        return rewards;
    }

    private int calculateTransactionPoints(Transaction tx) {
        int points = 0;
        int amount = tx.getAmount();

        if (amount > 100) {
            points += 2 * (amount - 100);
        }

        if (amount > 50) {
            points += amount < 100 ? amount - 50 : 50;
        }

        return points;
    }

    private String getMonth(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int month = cal.get(Calendar.MONTH)+ 1;

        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid";
        };

    }

}
