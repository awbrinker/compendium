package compendium

class MagicItemLibrary {

    static void overload() {
        for(int i = 0; i<1000; i++){
            def akmon = new MagicItem(
            name: "Akmon, Hammer of Purphoros"+i,
            rarity: "Artifact",
            type: "Weapon",
            subtype: "warhammer",
            attunement: true,
            attuneNotes: "",
            notes: "Immunity: Exhaustion, Resistance: Fire, Bonus: Magic, Damage: Fire, Proficiency: Smith's Tools, Versatile",
            body: """Purphoros’s hammer works wonders and disasters, the god of the forge using it to craft ground-breaking marvels and dangerous inventions in equal measure. Purphoros rarely bestows Akmon on mortals but occasionally leaves it unattended at his forge in Mount Velus. When Purphoros does permit a mortal to use the hammer, it’s usually so they might bring an important work into being, wreck a force of destruction, or forge something remarkable somewhere the god isn’t welcome.

Hammer of the Forge. This magic warhammer grants a +3 bonus to attack and damage rolls made with it. When you hit with an attack using it, the target takes an extra 3d10 fire damage.

Blessing of the Forge. If you are a worshiper of Purphoros, you gain all the following benefits for which you have the required piety:

Piety 10+. The hammer has 1 randomly determined minor beneficial property.

Piety 25+. The hammer has 1 randomly determined major beneficial property.

Piety 50+. The hammer has 1 additional randomly determined major beneficial property.

If you aren’t a worshiper of Purphoros, the hammer has 2 randomly determined minor detrimental properties.

See “Artifacts” in chapter 7 of the Dungeon Master’s Guide for details on randomly determined properties.

Reforged. While holding the hammer, you have resistance to fire damage and are immune to exhaustion. Additionally, you have proficiency with smith’s tools and have advantage on all ability checks made using them.

Spells. While the hammer is on your person, you can use an action to cast one of the following spells (save DC 18): animate objects, heat metal, fabricate, magic weapon, mending, shatter. Once you use the hammer to cast a spell, the spell can’t be cast again from it until the next dusk.

Destroying the Hammer. To destroy the hammer, it must be taken to the realm of Tizerus, in the Underworld. There it must be coated in clay from the Mire of Punishment. The heat of the hammer hardens the clay, which fuses to it after one month. Once fully hardened, the clay-covered hammer must be swallowed and digested by a kraken.

Proficiency with a warhammer allows you to add your proficiency bonus to the attack roll for any attack you make with it.""",
            source: "Mythic Odysseys of Theros"
        ).save(flush: true)
        }
    }

    static void initialize() {

        def absorbingTattoo = new MagicItem(
            name: "Absorbing Tattoo",
            rarity: "Very Rare",
            type: "Wondrous Item",
            subtype: "tattoo",
            attunement: true,
            attuneNotes: "",
            notes: "",
            body: """Produced by a special needle, this magic tattoo features designs that emphasize one color.

Tattoo Attunement.  To attune to this item, you hold the needle to your skin where you want the tattoo to appear, pressing the needle there throughout the attunement process. When the attunement is complete, the needle turns into the ink that becomes the tattoo, which appears on the skin. If your attunement to the tattoo ends, the tattoo vanishes, and the needle reappears in your space.

Damage Resistance. While the tattoo is on your skin, you have resistance to a type of damage associated with that color, as shown on the table below. The DM chooses the color or determines it randomly.

d10     Damage Type     Color
1       Acid            Green
2       Cold            Blue
3       Fire            Red
4       Force           White
5       Lightning       Yellow
6       Necrotic        Black
7       Poison          Violet
8       Psychic         Silver
9       Radiant         Gold
10      Thunder         Orange

Damage Absorption. When you take damage of the chosen type, you can use your reaction to gain immunity against that instance of the damage, and you regain a number of hit points equal to half the damage you would have taken. Once this reaction is used, it can’t be used again until the next dawn.""",
            source: "Tasha's Cauldron of Everything"
        ).save(flush: true)

        def acheronBlade = new MagicItem(
            name: "Acheron Blade",
            rarity: "Rare",
            type: "Weapon",
            subtype: "any sword",
            attunement: true,
            attuneNotes: "",
            notes: "Bonus: Magic, Bonus: Temporary Hit Points",
            body: """The black blade of this sword is crafted from a mysterious arcane alloy. You gain a +1 bonus to attack and damage rolls made with this magic weapon. While the sword is on your person, you are immune to effects that turn undead.

Dark Blessing. While holding the sword, you can use an action to give yourself 1d4 + 4 temporary hit points. This property can’t be used again until the next dusk.

Disheartening Strike. When you hit a creature with an attack using this weapon, you can fill the target with unsettling dread: the target has disadvantage on the next saving throw it makes before the end of your next turn. The creature ignores this effect if it’s immune to the frightened condition. Once you use this property, you can’t do so again until the next dusk.""",
            source: "Explorer's Guide to Wildemount"
        ).save(flush: true)

        def adamantineArmor = new MagicItem(
            name: "Adamantine Armor",
            rarity: "Uncommon",
            type: "Armor",
            subtype: "medium or heavy, but not hide",
            attunement: false,
            attuneNotes: "",
            notes: "Immunity: Critical Hits, Combat, Warding",
            body: """This suit of armor is reinforced with adamantine, one of the hardest substances in existence. While you're wearing it, any critical hit against you becomes a normal hit.""",
            source: "Basic rules"
        ).save(flush: true)

        def akmon = new MagicItem(
            name: "Akmon, Hammer of Purphoros",
            rarity: "Artifact",
            type: "Weapon",
            subtype: "warhammer",
            attunement: true,
            attuneNotes: "",
            notes: "Immunity: Exhaustion, Resistance: Fire, Bonus: Magic, Damage: Fire, Proficiency: Smith's Tools, Versatile",
            body: """Purphoros’s hammer works wonders and disasters, the god of the forge using it to craft ground-breaking marvels and dangerous inventions in equal measure. Purphoros rarely bestows Akmon on mortals but occasionally leaves it unattended at his forge in Mount Velus. When Purphoros does permit a mortal to use the hammer, it’s usually so they might bring an important work into being, wreck a force of destruction, or forge something remarkable somewhere the god isn’t welcome.

Hammer of the Forge. This magic warhammer grants a +3 bonus to attack and damage rolls made with it. When you hit with an attack using it, the target takes an extra 3d10 fire damage.

Blessing of the Forge. If you are a worshiper of Purphoros, you gain all the following benefits for which you have the required piety:

Piety 10+. The hammer has 1 randomly determined minor beneficial property.

Piety 25+. The hammer has 1 randomly determined major beneficial property.

Piety 50+. The hammer has 1 additional randomly determined major beneficial property.

If you aren’t a worshiper of Purphoros, the hammer has 2 randomly determined minor detrimental properties.

See “Artifacts” in chapter 7 of the Dungeon Master’s Guide for details on randomly determined properties.

Reforged. While holding the hammer, you have resistance to fire damage and are immune to exhaustion. Additionally, you have proficiency with smith’s tools and have advantage on all ability checks made using them.

Spells. While the hammer is on your person, you can use an action to cast one of the following spells (save DC 18): animate objects, heat metal, fabricate, magic weapon, mending, shatter. Once you use the hammer to cast a spell, the spell can’t be cast again from it until the next dusk.

Destroying the Hammer. To destroy the hammer, it must be taken to the realm of Tizerus, in the Underworld. There it must be coated in clay from the Mire of Punishment. The heat of the hammer hardens the clay, which fuses to it after one month. Once fully hardened, the clay-covered hammer must be swallowed and digested by a kraken.

Proficiency with a warhammer allows you to add your proficiency bonus to the attack roll for any attack you make with it.""",
            source: "Mythic Odysseys of Theros"
        ).save(flush: true)

        def apparatusOfTheCrab = new MagicItem(
            name: "Apparatus of the Crab",
            rarity: "Legendary",
            type: "Wondrous Item",
            subtype: "",
            attunement: false,
            attuneNotes: "",
            notes: "Utility, Exploration, Combat",
            body: """This item first appears to be a Large sealed iron barrel weighing 500 pounds. The barrel has a hidden catch, which can be found with a successful DC 20 Intelligence (Investigation) check. Releasing the catch unlocks a hatch at one end of the barrel, allowing two Medium or smaller creatures to crawl inside. Ten levers are set in a row at the far end, each in a neutral position, able to move either up or down. When certain levers are used, the apparatus transforms to resemble a giant lobster. The apparatus of the Crab is a Large object with the following statistics:

Armor Class: 20
Hit Points: 200
Speed: 30 ft., swim 30 ft. (or 0 ft. for both if the legs and tail aren't extended)
Damage Immunities: poison, psychic

To be used as a vehicle, the apparatus requires one pilot. While the apparatus's hatch is closed, the compartment is airtight and watertight. The compartment holds enough air for 10 hours of breathing, divided by the number of breathing creatures inside.

The apparatus floats on water. It can also go underwater to a depth of 900 feet. Below that, the vehicle takes 2d6 bludgeoning damage per minute from pressure.

A creature in the compartment can use an action to move as many as two of the apparatus's levers up or down. After each use, a lever goes back to its neutral position. Each lever, from left to right, functions as shown in the Apparatus of the Crab Levers table.

Apparatus of the Crab Levers
Lever	Up	Down
1	Legs and tail extend, allowing the apparatus to walk and swim.	Legs and tail retract, reducing the apparatus's speed to 0 and making it unable to benefit from bonuses to speed.
2	Forward window shutter opens.	Forward window shutter closes.
3	Side window shutters open (two per side).	Side window shutters close (two per side).
4	Two claws extend from the front sides of the apparatus.	The claws retract.
5	Each extended claw makes the following melee weapon attack: +8 to hit, reach 5 ft., one target. Hit: 7 (2d6) bludgeoning damage.	Each extended claw makes the following melee weapon attack: +8 to hit, reach 5 ft., one target. Hit: The target is grappled (escape DC 15).
6	The apparatus walks or swims forward.	The apparatus walks or swims backward.
7	The apparatus turns 90 degrees left.	The apparatus turns 90 degrees right.
8	Eyelike fixtures emit bright light in a 30-foot radius and dim light for an additional 30 feet.	The light turns off.
9	The apparatus sinks as much as 20 feet in liquid.	The apparatus rises up to 20 feet in liquid.
10	The rear hatch unseals and opens.	The rear hatch closes and seals.""",
            source: "Basic Rules"
        ).save(flush: true)

        def armblade = new MagicItem(
            name: "Armblade",
            rarity: "Common",
            type: "Weapon",
            subtype: "any one-handed melee weapon",
            attunement: true,
            attuneNotes: "Warforged",
            notes: "Warforged, Damage, Combat, Light",
            body: """An armblade is a magic weapon that attaches to your arm, becoming inseparable from you as long as you're attuned to it. To attune to this item, you must hold it against your forearm for the entire attunement period.

As a bonus action, you can retract the armblade into your forearm or extend it from there. While it is extended, you can use the weapon as if you were holding it, and you can't use that hand for other purposes.""",
            source: "Wayfinder's Guide to Eberron"
        ).save(flush: true)

    }

}