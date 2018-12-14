new Vue({
    el : '#app',
    data:{
        categories:[]
    },
    mounted:function(){
        var self = this;
        axios.post("/getcategories").then(function(response) {
            console.log(response.data("model"));
            self.categories= response.data; //此时还是字符串
            self.categories = eval("("+self.categories+")");  //字符串转换为数组对象
        })
    },
    methods:{


    }
})