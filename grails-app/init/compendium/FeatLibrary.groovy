package compendium

import groovy.json.JsonSlurper

class FeatLibrary {

    static void initialize() {
        def jsonSlurper = new JsonSlurper()
        def contents = jsonSlurper.parse(new File("data/feats.json"))

            for(int i = 0; i < contents.feat.size(); i++){
                def feat = contents.feat.get(i)

                def initFeat = new Feat(

                   name: feat.name,
                   notes: feat.notes,
                   tags: feat.tags,
                   prereq: feat.prereq,
                   source: feat.source,
                   body: feat.body,

                ).save(flush:true)

            if(!initFeat)
                println feat.name
        }

    }

}