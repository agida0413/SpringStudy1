let app = Vue.createApp({
	  data() {
	    return {
	      food_list: [], // arrayList ,  [{},{}]
	      food_detail: {}, // vo
	      fno: 0,
	      isShow: false
	    };
	  },
	  // 브라우저 실행 처리 = > window.onload 
	  mounted() {
	    axios.get('../food/list_vue.do')
	      .then(response => {
	        // then = > success()  response 안 결과값
	        this.food_list = response.data;
	      });
	  },
	  methods: {
	    detail(fno) {
	    	this.isShow=true;
	        this.fno = fno;
	        let _this = this;
	      axios.get('../food/detail_vue.do', {
	        params: {
	          // 파라미터값 보내기 
	          fno: _this.fno
	        }
	      })
	      .then(function(response) {
	    	  console.log(response.data)
	        _this.food_detail = response.data;
	      });
	    }
	  }
	}).mount('#app');