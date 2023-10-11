package robledo.home.demo.model;

import java.util.List;

public class RewardPoints {

    private long customerId;
    private String customer;
    private int totalPoints;

    private List<PointsPerMonth> pointsPerMonths;

    // getter and setters
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {

        this.customerId = customerId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public List<PointsPerMonth> getPointsPerMonths() {
        return pointsPerMonths;
    }

    public void setPointsPerMonths(List<PointsPerMonth> pointsPerMonths) {
        this.pointsPerMonths = pointsPerMonths;
    }

    public static class PointsPerMonth {
        private long customerId;

        private String month;

        private int points;

        // getters and setters

        public String getMonth() {

            return month;
        }

        public void setMonth(String month) {

            this.month = month;
        }

        public int getPoints() {

            return points;
        }

        public void setPoints(int points) {

            this.points = points;
        }

        public PointsPerMonth() { }
    }

}
