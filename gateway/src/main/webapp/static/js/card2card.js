var payee = $('#getPayee').attr('payee')
var cardNum = $('#CashCard').attr('cardNum')
var bankName = $('#bankName').attr('bankName')
var cash = $('#orderAmount').attr('cash')
var desc = $('#desc').attr('desc')

var clipboard0, clipboard1, clipboard2, clipboard3, clipboard4

Zepto(function ($) {
    if(IsPC()){ //pc端
        $('.andBtn').css('display', 'block')
    } else {
        var htmlWidth = document.documentElement.clientWidth || document.body.clientWidth;
        //设置根元素字体大小
        $('html').css('fontSize', htmlWidth/20 + 'px')

        $('.demo').css('display', 'none')
        $('.payType').css('width', '100%')
        $('.tipContainer').css('display', 'none')

        if(isIOS()) {
            $('.iosBtn').css('display', 'block')
        } else {
            $('.andBtn').css('display', 'block')
        }

    }

    clipboard0 = new ClipboardJS('.payBtn',{
        target: function() {
            return document.getElementById('getPayee')
        }
    });

    clipboard1 = new ClipboardJS('.cardBtn',{
        target: function() {
            return document.getElementById('CashCard')
        }
    });

    clipboard2 = new ClipboardJS('.nameBtn',{
        target: function() {
            return document.getElementById('bankName')
        }
    });
    clipboard3 = new ClipboardJS('.cashBtn',{
        target: function() {
            return document.getElementById('orderAmount')
        }
    });
    clipboard4 = new ClipboardJS('.descBtn',{
        target: function() {
            return document.getElementById('desc')
        }
    });
    for(var i=0;i<5;i++) {
        this['clipboard'+i].on('success', function(e) {
            $(document).dialog({
                content: '复制成功:'+e.text
            })
        });
    }


    $('#getPayee').text(payee)
    $('#CashCard').text(cardNum)
    $('#bankName').text(bankName)
    $('#orderAmount').text(cash)
    $('#desc').text(desc)

    $('.detail-cash').text(cash)
    $('.detail-desc').text(desc)

    $('.openAlipay').on('click', function (e) {
        // body...
        console.log('ssdfasdf')
        $('.openAlipay').attr('href', 'alipays://platformapi/startapp?appId=09999988')
    })

})

function hasAlipay() {
      var t1 = Date.now(); 
      var ifr = document.createElement("iframe"); 
      ifr.setAttribute('src', url); 
      ifr.setAttribute('style', 'display:none'); 
      document.body.appendChild(ifr); 
      timeout = setTimeout(function () { 
         var t2 = Date.now(); 
         if (!t1 || t2 - t1 < t + 100) { 
           hasApp = false; 
         } 
      }, 1000);
}

function IsPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = ["Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod"];
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
    return flag;
}

function isIOS(){ 
    var equipmentType = ""; 
    var agent = navigator.userAgent.toLowerCase(); 
    var android = agent.indexOf("android"); 
    var iphone = agent.indexOf("iphone"); 
    var ipad = agent.indexOf("ipad"); 
    if(android != -1){ 
        return false
    } 
    if(iphone != -1 || ipad != -1){ 
        return true 
    }
    return false
}

function mobileClose() {
    var muserAgent = navigator.userAgent
    if (muserAgent.indexOf('Firefox') != -1 || muserAgent.indexOf('Chrome')!=-1) {
        window.location.href='about:blank';
    } else if(muserAgent.indexOf('Android')> -1 || muserAgent.indexOf('Linux')> -1){
        window.opener=null;
        window.open('about:blank', '_self').close();
    } else {
        window.opener = null;
        window.open('about:blank', '_self')
        window.close();
    }
}

function isWeixin() { //判断是否是微信
    var ua = navigator.userAgent.toLowerCase();
    return ua.match(/MicroMessenger/i) == "micromessenger";
};