function toggleInsp(){
    if(document.getElementById('insp').style.display == 'none'){
        document.getElementById('insp').style.display = 'inline'
    }else{
        document.getElementById('insp').style.display = 'none'
    }

    if(document.getElementsByName('inspValue')[0].value == 'false'){
        document.getElementsByName('inspValue')[0].value = 'true'
    }else{
        document.getElementsByName('inspValue')[0].value = 'false'
    }

    console.log(document.getElementsByName('inspValue')[0].value)
}

function heal(){
    var hpchange = parseInt(document.getElementById('hpchange').value)
    var hp = parseInt(document.getElementById('hp').value)
    var maxHp = parseInt(document.getElementById('maxhp').value)

    if(hpchange != NaN && hp != NaN && maxHp != NaN){
        if(hp + hpchange > maxHp){
            document.getElementById('hp').value = maxHp
        }else{
            document.getElementById('hp').value = hpchange+hp
        }
        document.getElementById('hpchange').value = 0

        // Hide death saves
    }
}

function damage(){
    var hpchange = parseInt(document.getElementById('hpchange').value)
    var hp = parseInt(document.getElementById('hp').value)
    var tempHp = parseInt(document.getElementById('temphp').value)
    
    if(hpchange != NaN && hp != NaN){
        if(tempHp != NaN){
            if(tempHp > hpchange){
                tempHp -= hpchange
                document.getElementById('temphp').value = tempHp
            }else{
                hpchange -= tempHp
                hp -= hpchange
                if(hp < 0){
                    hp = 0
                }
                document.getElementById('temphp').value = 0
                document.getElementById('hp').value = hp
            }
        }else{
            hp -= hpchange
            if(hp < 0){
                hp = 0
            }
            document.getElementById('hp').value = hp
        }
        document.getElementById('hpchange').value = 0

        // Show death saves
    }
}

function openTab(evt, tabName) {
    // Declare all variables
    var i, tabcontent, tablinks;
  
    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
  }

  function openActionTab(evt, tabName) {
    // Declare all variables
    var i, actiontabcontent, actiontablinks;

    if(tabName == 'all'){
        actiontabcontent = document.getElementsByClassName("actiontabcontent");
        for (i = 0; i < actiontabcontent.length; i++) {
            actiontabcontent[i].style.display = "block";
        }
        actiontablinks = document.getElementsByClassName("actiontablinks");
        for (i = 0; i < actiontablinks.length; i++) {
            actiontablinks[i].className = actiontablinks[i].className.replace(" active", "");
        }
        evt.currentTarget.className += " active";
        return
    }
  
    // Get all elements with class="tabcontent" and hide them
    actiontabcontent = document.getElementsByClassName("actiontabcontent");
    for (i = 0; i < actiontabcontent.length; i++) {
      actiontabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tablinks" and remove the class "active"
    actiontablinks = document.getElementsByClassName("actiontablinks");
    for (i = 0; i < actiontablinks.length; i++) {
        actiontablinks[i].className = actiontablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
  }

  function openInventoryTab(evt, tabName) {
    // Declare all variables
    var i, inventorytabcontent, inventorytablinks;

    if(tabName == 'all'){
        inventorytabcontent = document.getElementsByClassName("inventorytabcontent");
        for (i = 0; i < inventorytabcontent.length; i++) {
            inventorytabcontent[i].style.display = "block";
        }
        inventorytablinks = document.getElementsByClassName("inventorytablinks");
        for (i = 0; i < inventorytablinks.length; i++) {
            inventorytablinks[i].className = inventorytablinks[i].className.replace(" active", "");
        }
        evt.currentTarget.className += " active";
        return
    }
  
    // Get all elements with class="tabcontent" and hide them
    inventorytabcontent = document.getElementsByClassName("inventorytabcontent");
    for (i = 0; i < inventorytabcontent.length; i++) {
        inventorytabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tablinks" and remove the class "active"
    inventorytablinks = document.getElementsByClassName("inventorytablinks");
    for (i = 0; i < inventorytablinks.length; i++) {
        inventorytablinks[i].className = inventorytablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
  }

  function openFeatureTab(evt, tabName) {
    // Declare all variables
    var i, featuretabcontent, featuretablinks;

    if(tabName == 'all'){
        featuretabcontent = document.getElementsByClassName("featuretabcontent");
        for (i = 0; i < featuretabcontent.length; i++) {
            featuretabcontent[i].style.display = "block";
        }
        featuretablinks = document.getElementsByClassName("featuretablinks");
        for (i = 0; i < featuretablinks.length; i++) {
            featuretablinks[i].className = featuretablinks[i].className.replace(" active", "");
        }
        evt.currentTarget.className += " active";
        return
    }
  
    // Get all elements with class="tabcontent" and hide them
    featuretabcontent = document.getElementsByClassName("featuretabcontent");
    for (i = 0; i < featuretabcontent.length; i++) {
        featuretabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tablinks" and remove the class "active"
    featuretablinks = document.getElementsByClassName("featuretablinks");
    for (i = 0; i < featuretablinks.length; i++) {
        featuretablinks[i].className = featuretablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
  }

  function openSpellTab(evt, tabName) {
    // Declare all variables
    var i, spelltabcontent, spelltablinks;

    if(tabName == 'all'){
        spelltabcontent = document.getElementsByClassName("spelltabcontent");
        for (i = 0; i < spelltabcontent.length; i++) {
            spelltabcontent[i].style.display = "block";
        }
        spelltablinks = document.getElementsByClassName("spelltablinks");
        for (i = 0; i < spelltablinks.length; i++) {
            spelltablinks[i].className = spelltablinks[i].className.replace(" active", "");
        }
        evt.currentTarget.className += " active";
        return
    }
  
    // Get all elements with class="tabcontent" and hide them
    spelltabcontent = document.getElementsByClassName("spelltabcontent");
    for (i = 0; i < spelltabcontent.length; i++) {
        spelltabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tablinks" and remove the class "active"
    spelltablinks = document.getElementsByClassName("spelltablinks");
    for (i = 0; i < spelltablinks.length; i++) {
        spelltablinks[i].className = spelltablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
  }
