/**
 * 超级JS
 * @author K
 * @date 2019-07-29
 * 请以后所有JS都按照此格式要求撰写
 * 所有JS类的父类JS
 */
;(function (win, doc, $) {
    var CommonUtil = {
        init: function () {
            this.quickLink();
        },
        /**
         * ajax封装
         * @param url	JS连接
         * @param data	数据对象
         * @param sucFn	成功的方法
         * @param isAsync	是否数据同步 true  or false    默认为true
         * @param errFn	错误的方法
         * @param requestType	请求类型    get post  delete put ...
         */
       ObjextAjax: function (url, data, sucFn, isAsync, errFn,requestType) {
            $.ajax({
                url: url,
                data: data,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: requestType == null  || requestType == '' ?'post':requestType,
                dataType:"json",
                async: isAsync ? isAsync : true,
                success: function (res) {
                    if (typeof sucFn == 'function') sucFn(res);
                },
                error: function (err) {
            			layer.msg(err)
                }
            })
        },
        /**
         * 格式化时间戳
         * 获取当前时间的格式化时间
         * @returns {{year: number, month: number, weeks: string, day: number, hours: number, minutes: number, seconds: number, milliseconds: number}}
         */
        formatDate: function () {
            var d = new Date();
            var weeks = ['星期天', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
            function addZero(val) {
                if (val.length < 2) {
                    return '0'.concat(val);
                }
                return val;
            }
            return {
                year: d.getFullYear(),
                month: addZero((d.getMonth() + 1).toString()),
                weeks: weeks[d.getDay()],
                day: addZero(d.getDate().toString()),
                hours: addZero(d.getHours().toString()),
                minutes: addZero(d.getMinutes().toString()),
                seconds: addZero(d.getSeconds().toString()),
                milliseconds: d.getMilliseconds()
            };
        },
 
        /**
         *<p> 快捷链接</p>
         *使用方法  ： <div data-link="https://www.baidu.com" target>百度一下？</div>
         * @returns {CommonUtil}
         */
        quickLink: function () {
            $('body').on('click', '*[data-link]', function () { 
            var _url = $(this).data('link').toString();
            var _target = $(this).get(0).hasAttribute('target');
	            if (!!_url && _target) {
	                window.open(_url);
	            } else if (!!_url) {
	                location.href = _url;
	            }
            });
            return this;
        },
        /**
         * 获取地址栏后带参数
         * @returns {*}
         */
        getQueryString: function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]);
            return null;
        },

        /**
         * <p>这个功能大概率上是用不到的</p>
         * 创建script标签
         * @param src	   js文件	引用路径
         * @param parent   元素对象(指定位置之后)这里是一个前端节点对象
         */
        createScript: function (src, parent) {
            var tag = doc.createElement('script');
            tag.src = src;
            parent.appendChild(tag);
        },

        /**
         * 获取本地存储中的值
         * 本地储存
         * @param name
         * @returns {*}
         */
        getLocalData: function (key) {
            var result = localStorage.getItem(key);
            try {
                if ('object' == typeof JSON.parse(result)) return JSON.parse(result);
            } catch (e) {
                return result;
            }
        },

        /**
         * 设置本地存储值
         * 本地储存
         * @param key
         * @param value
         * @param isObj
         */
        setLocalData: function (key, value, isObj) {
            if (isObj) {
                return localStorage.setItem(key, JSON.stringify(value));
            }
            localStorage.setItem(key, value);
        },
        /**
         * 移除本地存储中的值
         * 本地储存
         * @param keyList   以数组格式传入字段名
         */
        removeLocalData: function (keyList) {
            $.each(keyList, function (index, obj) {
                localStorage.removeItem(obj);
            });
        },
        /**
         * 获取会话存储中的值
         * 会话缓存
         * @param name
         * @returns {*}
         */
        getSeesionData: function (key) {
            var result = sessionStorage.getItem(key);
            try {
                if ('object' == typeof JSON.parse(result)) return JSON.parse(result);
            } catch (e) {
                return result;
            }
        },
        /**
         * 移除会话存储中的值
         * 会话缓存
         * @param keyList   以数组格式传入字段名
         */
        removeSessionlData: function (keyList) {
            $.each(keyList, function (index, obj) {
            	sessionStorage.removeItem(obj);
            });
        },
        /**
         * 设置会话存储值
         * 会话缓存
         * @param key
         * @param value
         * @param isObj
         */
        setSessionData: function (key, value, isObj) {
            if (isObj) {
                return sessionStorage.setItem(key, JSON.stringify(value));
            }
            sessionStorage.setItem(key, value);
        },
    };
    win.CommonUtil = CommonUtil;
}(window, document, jQuery));

$(function () {
    CommonUtil.init();
});
