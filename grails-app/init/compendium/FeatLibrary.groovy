package compendium

class FeatLibrary {

    static void initialize() {

        def actor = new Feat(
            name: "Actor",
            notes: "+1 Charisma, skilled at mimicry and dramatics",
            tags: "Buff, Social, Deception",
            prereq: "",
            source: "Player's Handbook",
            body: """Skilled at mimicry and dramatics, you gain the following benefits:
Increase your Charisma score by 1, to a maximum of 20.
You have advantage on Charisma (Deception) and Charisma (Performance) checks when trying to pass yourself off as a different person.  
You can mimic the speech of another person or the sounds made by other creatures. You must have heard the person speaking, or heard the creature make the sound, for at least 1 minute. A successful Wisdom (Insight) check contested by your Charisma (Deception) check allows a listener to determine that the effect is faked."""
        ).save(flush: true)

        def alert = new Feat(
            name: "Alert",
            notes: "+5 Initiative, can't be surprised, no advantage for hidden attackers",
            tags: "Buff, Detection",
            prereq: "",
            source: "Player's Handbook",
            body: """Always on the lookout for danger, you gain the following benefits:
You gain a +5 bonus to initiative.
You can't be surprised while you are conscious.
Other creatures don’t gain advantage on attack rolls against you as a result of being unseen by you."""
        ).save(flush: true)

        def dragonFear = new Feat(
            name: "Dragon Fear",
            notes: "+1 Strength, Constitution, or Charisma, frighten with a breath weapon",
            tags: "Control, Buff, Racial Feat",
            prereq: "Dragonborn",
            source: "Xanathar's Guide to Everything",
            body: """When angered, you can radiate menace. You gain the following benefits:
Increase your Strength, Constitution, or Charisma score by 1, to a maximum of 20.
Instead of exhaling destructive energy, you can expend a use of your Breath Weapon trait to roar, forcing each creature of your choice within 30 feet of you to make a Wisdom saving throw (DC 8 + your proficiency bonus + your Charisma modifier). A target automatically succeeds on the save if it can’t hear or see you. On a failed save, a target becomes frightened of you for 1 minute. If the frightened target takes any damage, it can repeat the saving throw, ending the effect on itself on a success."""
        ).save(flush: true)
    }

}