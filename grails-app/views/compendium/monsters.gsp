<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>D&D Black Flag</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"> 
    <asset:javascript src="sendMessage.js"/>
    <asset:javascript src="sorttable.js"/>
    <asset:javascript src="paginator.js"/>
    <asset:link rel="icon" href="BlackFlagLogo.ico" type="image/x-ico"/>
    <asset:stylesheet href="home.css"/>
    <asset:stylesheet href="spell.css"/>
    <asset:stylesheet href="table.css"/>

</head>
<body>
<g:render template="/navbar" />

<div role="main" class="homePage">
    <div class="mainMenu">
            
            <%-- Filter By Header  --%>

            <div id="index_native" class="box"></div>
            <div id="table_box_bootstrap">
                <table class="sortable" id="data" name="data" style="text-align: left; width: 1400px">
                    <thead>
                    <th><b>CR</b></th>
                    <th><b>Name</b></th>
                    <th><b>Type</b></th>
                    <th><b>Subtype</b></th>
                    <th><b>Size</b></th>
                    <th><b>Alignment</b></th>
                    <th><b>Environment</b></th>
                    <th><b>Tags</b></th>
                    </thead>

                    <%-- TODO: Parameterized Limiting (All pages) --%>
                    <g:each in="${monsters.size() < 10 ? monsters : monsters.subList(0, 10)}">
                        <g:render template="/monster" model="[monster: it, hook: hook]" />
                    </g:each>
                </table>
            </div>

            <script type="text/javascript">
                window.addEventListener("load", function () {
                    var box = paginator({
                        table: document.getElementById("table_box_bootstrap").getElementsByTagName("table")[0],
                        box_mode: "list",
                    });
                    box.className = "box";
                    document.getElementById("table_box_bootstrap").appendChild(box);
                }, false);
            </script>

    </div>
</div>

</body>
</html>