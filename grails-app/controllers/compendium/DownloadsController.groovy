package compendium

import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils

class DownloadsController {

    def index() {
        render(view: "index")
    }

    def tools() {
        render(view: "tools")
    }

    def sources() {
        render(view: "sources")
    }

    def download(){
        File file = new File("grails-app/assets/downloads/"+params.item)
        render(file: file, fileName: params.item)
    }
}
