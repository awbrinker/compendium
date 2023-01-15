package compendium

class BackgroundLibrary {

    static void initialize() {

        def acolyte = new Background(
            name: "Acolyte",
            featureName: "Shelter of the Faithful",
            featureText: """As an acolyte, you command the respect of those who share your faith, and you can perform the religious ceremonies of your deity. You and your adventuring companions can expect to receive free healing and care at a temple, shrine, or other established presence of your faith, though you must provide any material components needed for spells. Those who share your religion will support you (but only you) at a modest lifestyle.

You might also have ties to a specific temple dedicated to your chosen deity or pantheon, and you have a residence there. This could be the temple where you used to serve, if you remain on good terms with it, or a temple where you have found a new home. While near your temple, you can call upon the priests for assistance, provided the assistance you ask for is not hazardous and you remain in good standing with your temple.""",
            tags: "Social, Religious",
            skills: "Insight, Religion",
            languages: "Two of your choice",
            tools: "",
            equipment: "A holy symbol (a gift to you when you entered the priesthood), a prayer book or prayer wheel, 5 sticks of incense, vestments, a set of common clothes, and a pouch containing 15 gp.",
            body: """You have spent your life in the service of a temple to a specific god or pantheon of gods. You act as an intermediary between the realm of the holy and the mortal world, performing sacred rites and offering sacrifices in order to conduct worshipers into the presence of the divine. You are not necessarily a cleric—performing sacred rites is not the same thing as channeling divine power.

Choose a god, a pantheon of gods, or some other quasi-divine being, and work with your DM to detail the nature of your religious service. The Gods of the Multiverse section contains a sample pantheon, from the Forgotten Realms setting. Were you a lesser functionary in a temple, raised from childhood to assist the priests in the sacred rites? Or were you a high priest who suddenly experienced a call to serve your god in a different way? Perhaps you were the leader of a small cult outside of any established temple structure, or even an occult group that served a fiendish master that you now deny.""",
            characteristics: """Acolytes are shaped by their experience in temples or other religious communities. Their study of the history and tenets of their faith and their relationships to temples, shrines, or hierarchies affect their mannerisms and ideals. Their flaws might be some hidden hypocrisy or heretical idea, or an ideal or bond taken to an extreme.""",
            source: "Basic Rules"
        ).save(flush: true)

        def anthropologist = new Background(
            name: "Anthropologist",
            featureName: "Adept Linguist",
            featureText: """You can communicate with humanoids who don’t speak any language you know. You must observe the humanoids interacting with one another for at least 1 day, after which you learn a handful of important words, expressions, and gestures—enough to communicate on a rudimentary level.""",
            tags: "Social, Exploration",
            skills: "Insight, Religion",
            languages: "Two of your choice",
            tools: "",
            equipment: "A leather-bound diary, a bottle of ink, an ink pen, a set of traveler’s clothes, one trinket of special significance, and a pouch containing 10 gp",
            body: """You have always been fascinated by other cultures, from the most ancient and primeval lost lands to the most modern civilizations. By studying other cultures’ customs, philosophies, laws, rituals, religious beliefs, languages, and art, you have learned how tribes, empires, and all forms of society in between craft their own destinies and doom. This knowledge came to you not only through books and scrolls, but also through first-hand observation—by visiting far-flung settlements and exploring local histories and customs.""",
            characteristics: """Anthropologists leave behind the societies into which they were born to discover what life is like in other parts of the world. They seek to see how other races and civilizations survive — or why they did not. Some anthropologists are driven by intellectual curiosity, while others want the fame and recognition that comes with being the first to discover a new people, a lost tribe, or the truth about an ancient empire’s downfall.""",
            source: "Tomb of Annihilation"
        ).save(flush: true)

        def athlete = new Background(
            name: "Athlete",
            featureName: "Echoes of Victory",
            featureText: """You have attracted admiration among spectators, fellow athletes, and trainers in the region that hosted your past athletic victories. When visiting any settlement within 100 miles of where you grew up, there is a 50 percent chance you can find someone there who admires you and is willing to provide information or temporary shelter.

Between adventures, you might compete in athletic events sufficient enough to maintain a comfortable lifestyle, as per the “Practicing a Profession” downtime activity in chapter 8 of the Player’s Handbook.""",
            tags: "Utility",
            skills: "Acrobatics, Athletics",
            languages: "One of your choice",
            tools: "Vehicles (land)",
            equipment: "A bronze discus or leather ball, a lucky charm or past trophy, a set of traveler’s clothes, and a pouch containing 10 gp",
            body: """You strive to perfect yourself physically and in execution of everything you do. The thrill of competition lights fire in your blood, and the roar of the crowd drives you forward. Tales of your exploits precede you and might open doors or loosen tongues.

Whether in one of the poleis, between them, or among the nonhuman peoples of Theros, physical contests and those who pursue them command respect bordering on reverence. Athletes arise from all walks of life and all cultures and quite often cross paths with one another.""",
            characteristics: """Competition can forge strong bonds between teammates and rivals or ignite bitter feuds that burn outside the arena. Athletes often apply lessons from their training to their lives in general.""",
            source: "Mythic Odysseys of Theros"
        ).save(flush: true)
    }

}