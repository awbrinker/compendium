package compendium

class MonsterLibrary {

    static void overload() {
        for(int i = 0; i < 2500; i++){
            def acererak = new Monster(
            name: "Acererak"+i,
            size: "Medium",
            type: "Undead",
            subtype: "",
            alignment: "Neutral Evil",

            environment: "",
            tags: "NPC",

            ac: 21,
            actext: "natural armor",

            hp: 285,
            hpformula: "30d8+150",
            speed: "30 ft.",

            stats: [12, 16, 20, 27, 21, 20],
            saves: [0, 0, 1, 1, 1, 0],

            skills: ["Arcana", "History", "Insight", "Perception", "Religion"],
            skillBonus: [22, 22, 12, 12, 15],

            resistances: ["Cold", "Lightning"],
            immunities: ["Necrotic", "Poison", "Bludgeoning, Piercing, and Slashing from Nonmagical Attacks"],
            vulnerabilities: null,
            conditionImmunities: ["Blinded", "Charmed", "Deafened", "Exhaustion", "Frightened", "Paralyzed", "Petrified", "Poisoned", "Stunned"],

            senses: "Truesight 120 ft., Passive Perception 22",
            languages: "Abyssal, Common, Draconic, Dwarvish, Elvish, Giant, Infernal, Primordial, Undercommon",

            cr: "23",
            prof: 7,

            attributes: ["Special Equipment. Acererak carries the Staff of the Forgotten One. He wears a talisman of the sphere and has a sphere of annihilation under his control.",
                        "Legendary Resistance (3/Day). If Acererak fails a saving throw, he can choose to succeed instead.",
                        "Rejuvenation. Acererak’s body turns to dust when he drops to 0 hit points, and his equipment is left behind. Acererak gains a new body after 1d10 days, regaining all his hit points and becoming active again. The new body appears within 5 feet of Acererak’s phylactery, the location of which is hidden.",
                        """Spellcasting. Acererak is a 20th-level spellcaster. His spellcasting ability is Intelligence (spell save DC 23, +15 to hit with spell attacks). Acererak has the following wizard spells prepared:
Cantrips (at will): mage hand, ray of frost, shocking grasp
1st level (at will): ray of sickness, shield
2nd level (at will): arcane lock, knock
3rd level (at will): animate dead, counterspell
4th level (3 slots): blight, ice storm, phantasmal killer
5th level (3 slots): cloudkill, hold monster, wall of force
6th level (3 slots): chain lightning, circle of death, disintegrate
7th level (3 slots): finger of death, plane shift, teleport
8th level (2 slots): maze, mind blank
9th level (2 slots): power word kill, time stop""",
                        "Turn Resistance. Acererak has advantage on saving throws against any effect that turns undead."],
            attributeFormulas: ["None", "None", "d10", "d20+15", "None"],
            actions: ["Paralyzing Touch. Melee Spell Attack: +8 to hit, reach 5 ft., one creature. Hit: 10 (3d6) cold damage, and the target must succeed on a DC 20 Constitution saving throw or be paralyzed for 1 minute. The target can repeat the saving throw at the end of each of its turns, ending the effect on itself on a success.",
                        "Staff. Melee Weapon Attack: +11 to hit, reach 5 ft., one target. Hit: 7 (1d6 + 4) bludgeoning damage plus 10 (3d6) necrotic damage, or 8 (1d8 + 4) bludgeoning damage plus 10 (3d6) necrotic damage when used with two hands.",
                        "Invoke Curse. While holding the Staff of the Forgotten One, Acererak expends 1 charge from it and targets one creature he can see within 60 feet of him. The target must succeed on a DC 23 Constitution saving throw or be cursed. Until the curse is ended, the target can’t regain hit points and has vulnerability to necrotic damage. Greater Restoration, remove curse or similar magic ends the curse on the target."],
            actionFormulas: ["d20+8 & 3d6", "d20+11 & 1d6+4 & 1d8+4 & 3d6", "None"], 
            legendaryActions: ["Acererak can take 3 legendary actions, choosing from the options below. Only one legendary action option can be used at a time and only at the end of another creature’s turn. Acererak regains spent legendary actions at the start of his turn.",
                                "At-Will Spell. Acererak casts one of his at-will spells.",
                                "Melee Attack. Acererak uses Paralyzing Touch or makes one melee attack with his staff.",
                                "Frightening Gaze (Costs 2 Actions). Acererak fixes his gaze on one creature he can see within 10 feet of him. The target must succeed on a DC 20 Wisdom saving throw against this magic or become frightened for 1 minute. The frightened target can repeat the saving throw at the end of each of its turns, ending the effect on itself on a success. If a target's saving throw is successful or the effect ends on it, the target is immune to Acererak's gaze for the next 24 hours.",
                                "Talisman of the Sphere (Costs 2 Actions). Acererak uses his talisman of the sphere to move the sphere of annihilation under his control up to 90 feet.",
                                "Disrupt Life (Costs 3 Actions). Each creature within 20 feet of Acererak must make a DC 20 Constitution saving throw against this magic, taking 42 (12d6) necrotic damage on a failed save, or half as much damage on a successful one."],
            legendaryActionFormulas: ["None", "None", "None", "None", "None", "12d6"],

            bonusActions: null,
            bonusActionFormulas: null,
            reactions: null,
            reactionFormulas: null,

            source: "Mordenkainen's Tome of Foes"
        ).save(flush:true)
        }
    }

    static void initialize() {

        def aarakocra = new Monster(
            name: "Aarakocra",
            size: "Medium",
            type: "Humanoid",
            subtype: "Aarakocra",
            alignment: "Neutral Good",

            environment: "Mountain",
            tags: "",

            ac: 12,
            actext: "",

            hp: 13,
            hpformula: "3d8",
            speed: "20 ft., fly 50 ft.",

            stats: [10, 14, 10, 11, 12, 11],
            saves: [0, 0, 0, 0, 0, 0],

            skills: ["Perception"],
            skillBonus: [5],

            resistances: null,
            immunities: null,
            vulnerabilities: null,
            conditionImmunities: null,

            senses: "Passive Perception 15",
            languages: "Aarakocra, Auran",

            cr: "1/4",
            prof: 2,

            attributes: ["Dive Attack. If the aarakocra is flying and dives at least 30 feet straight toward a target and then hits it with a melee weapon attack, the attack deals an extra 3 (1d6) damage to the target."],
            attributeFormulas: ["1d6"],
            actions: ["Talon. Melee Weapon Attack: +4 to hit, reach 5 ft., one target. Hit: 4 (1d4 + 2) slashing damage.",
                        "Javelin. Melee or Ranged Weapon Attack: +4 to hit, reach 5 ft. or range 30/120 ft., one target. Hit: 5 (1d6 + 2) piercing damage."],
            actionFormulas: ["d20+4 & 1d4+2", "d20+4 & 1d6+2"], 
            legendaryActions: null,
            legendaryActionFormulas: null,

            bonusActions: null,
            bonusActionFormulas: null,
            reactions: null,
            reactionFormulas: null,

            source: "Monster Manual"
        ).save(flush:true)

        def abyssalWretch = new Monster(
            name: "Abyssal Wretch",
            size: "Medium",
            type: "Fiend",
            subtype: "Demon",
            alignment: "Chaotic Evil",

            environment: "",
            tags: "Demon, Fiend",

            ac: 11,
            actext: "",

            hp: 18,
            hpformula: "4d8",
            speed: "20 ft.",

            stats: [9, 12, 11, 5, 8, 5],
            saves: [0, 0, 0, 0, 0, 0],

            skills: null,
            skillBonus: null,

            resistances: ["Cold", "Fire", "Lightning"],
            immunities: ["Poison"],
            vulnerabilities: null,
            conditionImmunities: ["Charmed", "Frightened", "Poisoned"],

            senses: "Darkvision 120 ft., Passive Perception 9",
            languages: "understands Abyssal but can't speak",

            cr: "1/4",
            prof: 2,

            attributes: null,
            attributeFormulas: null,
            actions: ["Bite. Melee Weapon Attack: +3 to hit, reach 5 ft., one target. Hit: 5 (1d8 + 1) slashing damage."],
            actionFormulas: ["d20+3 & 1d8+1"], 
            legendaryActions: null,
            legendaryActionFormulas: null,

            bonusActions: null,
            bonusActionFormulas: null,
            reactions: null,
            reactionFormulas: null,

            source: "Mordenkainen's Tome of Foes"
        ).save(flush:true)

        def acererak = new Monster(
            name: "Acererak",
            size: "Medium",
            type: "Undead",
            subtype: "",
            alignment: "Neutral Evil",

            environment: "",
            tags: "NPC",

            ac: 21,
            actext: "natural armor",

            hp: 285,
            hpformula: "30d8+150",
            speed: "30 ft.",

            stats: [12, 16, 20, 27, 21, 20],
            saves: [0, 0, 1, 1, 1, 0],

            skills: ["Arcana", "History", "Insight", "Perception", "Religion"],
            skillBonus: [22, 22, 12, 12, 15],

            resistances: ["Cold", "Lightning"],
            immunities: ["Necrotic", "Poison", "Bludgeoning, Piercing, and Slashing from Nonmagical Attacks"],
            vulnerabilities: null,
            conditionImmunities: ["Blinded", "Charmed", "Deafened", "Exhaustion", "Frightened", "Paralyzed", "Petrified", "Poisoned", "Stunned"],

            senses: "Truesight 120 ft., Passive Perception 22",
            languages: "Abyssal, Common, Draconic, Dwarvish, Elvish, Giant, Infernal, Primordial, Undercommon",

            cr: "23",
            prof: 7,

            attributes: ["Special Equipment. Acererak carries the Staff of the Forgotten One. He wears a talisman of the sphere and has a sphere of annihilation under his control.",
                        "Legendary Resistance (3/Day). If Acererak fails a saving throw, he can choose to succeed instead.",
                        "Rejuvenation. Acererak’s body turns to dust when he drops to 0 hit points, and his equipment is left behind. Acererak gains a new body after 1d10 days, regaining all his hit points and becoming active again. The new body appears within 5 feet of Acererak’s phylactery, the location of which is hidden.",
                        """Spellcasting. Acererak is a 20th-level spellcaster. His spellcasting ability is Intelligence (spell save DC 23, +15 to hit with spell attacks). Acererak has the following wizard spells prepared:
Cantrips (at will): mage hand, ray of frost, shocking grasp
1st level (at will): ray of sickness, shield
2nd level (at will): arcane lock, knock
3rd level (at will): animate dead, counterspell
4th level (3 slots): blight, ice storm, phantasmal killer
5th level (3 slots): cloudkill, hold monster, wall of force
6th level (3 slots): chain lightning, circle of death, disintegrate
7th level (3 slots): finger of death, plane shift, teleport
8th level (2 slots): maze, mind blank
9th level (2 slots): power word kill, time stop""",
                        "Turn Resistance. Acererak has advantage on saving throws against any effect that turns undead."],
            attributeFormulas: ["None", "None", "d10", "d20+15", "None"],
            actions: ["Paralyzing Touch. Melee Spell Attack: +8 to hit, reach 5 ft., one creature. Hit: 10 (3d6) cold damage, and the target must succeed on a DC 20 Constitution saving throw or be paralyzed for 1 minute. The target can repeat the saving throw at the end of each of its turns, ending the effect on itself on a success.",
                        "Staff. Melee Weapon Attack: +11 to hit, reach 5 ft., one target. Hit: 7 (1d6 + 4) bludgeoning damage plus 10 (3d6) necrotic damage, or 8 (1d8 + 4) bludgeoning damage plus 10 (3d6) necrotic damage when used with two hands.",
                        "Invoke Curse. While holding the Staff of the Forgotten One, Acererak expends 1 charge from it and targets one creature he can see within 60 feet of him. The target must succeed on a DC 23 Constitution saving throw or be cursed. Until the curse is ended, the target can’t regain hit points and has vulnerability to necrotic damage. Greater Restoration, remove curse or similar magic ends the curse on the target."],
            actionFormulas: ["d20+8 & 3d6", "d20+11 & 1d6+4 & 1d8+4 & 3d6", "None"], 
            legendaryActions: ["Acererak can take 3 legendary actions, choosing from the options below. Only one legendary action option can be used at a time and only at the end of another creature’s turn. Acererak regains spent legendary actions at the start of his turn.",
                                "At-Will Spell. Acererak casts one of his at-will spells.",
                                "Melee Attack. Acererak uses Paralyzing Touch or makes one melee attack with his staff.",
                                "Frightening Gaze (Costs 2 Actions). Acererak fixes his gaze on one creature he can see within 10 feet of him. The target must succeed on a DC 20 Wisdom saving throw against this magic or become frightened for 1 minute. The frightened target can repeat the saving throw at the end of each of its turns, ending the effect on itself on a success. If a target's saving throw is successful or the effect ends on it, the target is immune to Acererak's gaze for the next 24 hours.",
                                "Talisman of the Sphere (Costs 2 Actions). Acererak uses his talisman of the sphere to move the sphere of annihilation under his control up to 90 feet.",
                                "Disrupt Life (Costs 3 Actions). Each creature within 20 feet of Acererak must make a DC 20 Constitution saving throw against this magic, taking 42 (12d6) necrotic damage on a failed save, or half as much damage on a successful one."],
            legendaryActionFormulas: ["None", "None", "None", "None", "None", "12d6"],

            bonusActions: null,
            bonusActionFormulas: null,
            reactions: null,
            reactionFormulas: null,

            source: "Mordenkainen's Tome of Foes"
        ).save(flush:true)

    }

}