package compendium

class VehicleLibrary {

    static void initialize() {

        def galley = new Vehicle(
            name: "Galley",
            size: "Gargantuan",
            sizetext: "130 ft. by 20 ft.",
            crew: "80 crew, 40 passengers",
            cargo: "150 tons",
            pace: "4 miles per hour (96 miles per day)",

            stats: [24, 4, 20, 0, 0, 0],

            actions: ["On its turn, the galley can take 3 actions, choosing from the options below. It can take only 2 actions if it has fewer than forty crew and only 1 action if it has fewer than twenty. It can't take these actions if it has fewer than three crew.",
                    "Fire Ballistas. The galley can fire its ballistas (DMG, ch. 8).",
                    "Fire Mangonels. The galley can fire its mangonels (DMG, ch. 8).",
                    "Move. The galley can use its helm to move with its oars or sails. As part of this move, it can use its naval ram."],

            actionFormulas: ["None", "None", "None", "None"],

            components: [
                ["Hull",
                "Armor Class 15",
                "Hit Points 500 (damage threshold 20)"],

                ["Control: Helm",
                "Armor Class 16",
                "Hit Points 50",
                "Move up to the speed of one of the ship's movement components, with one 90-degree turn. If the helm is destroyed, the galley can't turn."],

                ["Movement: Oars",
                "Armor Class 12",
                "Hit Points 100; -5 ft. speed per 25 damage taken",
                "Speed (water) 30 ft. (requires at least 40 crew)"],

                ["Movement: Sails",
                "Armor Class 12",
                "Hit Points 100; -10 ft. speed per 25 damage taken",
                "Speed (water) 35 ft.; 15 ft. while sailing into the wind; 50 ft. while sailing with the wind"],

                ["Weapon: Ballista (4)",
                "Armor Class 15",
                "Hit Points 50 each",
                "Ranged Weapon Attack: +6 to hit, range 120/480 ft., one target. Hit: 16 (3d10) piercing damage."],

                ["Weapon: Mangonel (2)",
                "Armor Class 15",
                "Hit Points 100 each",
                "Ranged Weapon Attack: +5 to hit, range 200/800 ft. (can't hit targets within 60 ft. of it), one target. Hit: 27 (5d10) bludgeoning damage."],

                ["Weapon: Naval Ram",
                "Armor Class 20",
                "Hit Points 100 (damage threshold 10)",
                "The galley has advantage on all saving throws relating to crashing when it crashes into a creature or an object. Any damage it takes from the crash is applied to the naval ram rather than to the ship. These benefits dont apply if another vessel crashes into the galley."]
            ],

            compFormulas: [
                ["None", "None", "None"],
                ["None", "None", "None", "None"],
                ["None", "None", "None", "None"],
                ["None", "None", "None", "None"],
                ["None", "None", "None", "d20+6 & 3d10"],
                ["None", "None", "None", "d20+5 & 5d10"],
                ["None", "None", "None", "None"],
            ]

        ).save(flush: true)
    }
}