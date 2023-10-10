package compendium

class Character {

    String hook
    String name
    String raceclass
    int xp
    int nextxp
    int STR
    int DEX
    int CON
    int INT
    int WIS
    int CHA
    int prof
    int speed
    boolean insp
    int hp
    int maxhp
    int maxhpchange
    int temphp
    int successes
    int failures
    int[] hitDice
    int[] hitDiceCount
    int[] maxHitDice
    int[] saves
    String[] savenotes
    String senses 
    String armorProfs
    String weaponProfs
    String toolProfs
    String languages
    int[] skills
    int initbonus
    int ac
    String defences
    String conditions
    boolean spellcaster
    int spellstat
    int maxspelllevel
    int[] spellslots
    int[] maxspellslots
    String background
    String backgroundfeaturename
    String backgroundfeaturebody
    String[] characteristics

    static hasMany = [
        actions: Action,
        spells: Spell,
        features: Feature,
        inventory: InventoryItem
    ]

    static constraints = {
        hook(nullable: true)
        backgroundfeaturebody(maxSize: 1024)
        spellslots(nullable: true)
        maxspellslots(nullable: true)
    }

}
