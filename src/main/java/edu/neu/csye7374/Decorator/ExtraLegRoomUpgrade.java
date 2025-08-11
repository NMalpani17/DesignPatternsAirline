// package edu.neu.csye7374.Decorator;


// public class ExtraLegRoomUpgrade extends FlightUpgrade{
//     double extraLegRoomCharge = 29.99;
//     public ExtraLegRoomUpgrade(FlightUpgradeOptions upgradeOptions) {
//         super(upgradeOptions);
//     }

//     public double basePrice() {
//         return this.upgradeOptions.getBasePrice() + extraLegRoomCharge;
//     }

//     public String getUpgradeDescription() {
//         return this.upgradeOptions.getUpgradeDescription() + " with Extra Leg Room Upgrade";
//     }
// }
package edu.neu.csye7374.Decorator;

public class ExtraLegRoomUpgrade extends FlightUpgrade {
    double extraLegRoomCharge = 29.99;

    public ExtraLegRoomUpgrade(FlightUpgradeOptions upgradeOptions) {
        super(upgradeOptions);
    }

    // @Override
    // public double getBasePrice() {
    //     return this.upgradeOptions.getBasePrice() + extraLegRoomCharge;
    // }
    @Override
    public double getBasePrice() {
        return super.getBasePrice() + 29.99; // Add the premium upgrade cost
    }

    @Override
    public String getUpgradeDescription() {
        return this.upgradeOptions.getUpgradeDescription() + " with Extra Leg Room Upgrade";
    }
}
