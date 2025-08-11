package edu.neu.csye7374.Decorator;
public class PremiumUpgrade extends FlightUpgrade{
    double premiumCharge = 99.99;
    public PremiumUpgrade(FlightUpgradeOptions upgradeOptions) {
        super(upgradeOptions);
    }

    // public double getBasePrice() {
    //     return this.upgradeOptions.getBasePrice() + premiumCharge;
    // }
    @Override
    public double getBasePrice() {
        return super.getBasePrice() + 99.99; // Add the extra legroom upgrade cost
    }

    public String getUpgradeDescription() {
        return this.upgradeOptions.getUpgradeDescription() + " with Premium Upgrade";
    }

}
