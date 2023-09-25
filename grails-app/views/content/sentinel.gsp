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

<g:hiddenField name="target" id="target" value="${hook}"/>

<div role="main" class="homePage">
    <div class="mainMenu">
            <div style="align-items: left; width: 100%">
                <a href="/content">
                    <button class="backbtn">
                        <p>Back</p>
                    </button>
                </a>
            </div>
            
            <div style="display: flex; flex-direction: horizontal">
                
                <div class="row">

                    <div style="align-items: left; width: 50%; display: flex; flex-direction: column; margin-right: 5%">
                    <h1>Sentinel</h1>
                    <h3>Warforged Cleric 2</h3>
                    <div>

                    <div style="align-items: right; width: 50%; display: flex; flex-direction: column; margin-right: 5%">
                    <p>Experience: 300/900
                    </p>
                    </div>

                </div>                

            </div>

    </div>
</div>

</body>
</html>