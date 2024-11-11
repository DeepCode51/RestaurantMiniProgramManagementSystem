// pages/type/type.js
const app =getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    createday:'',
    isHiddens:true,
    //进购物车队列顺序
    rank:0,
    //分类数据
     classtype:[],
     openid:"",
     //分类后的产品列表
     booklist:[],
     //分类前的初始数据
     imgurl:"../../images/mphoto/",
     totalprice:0,
     cartlist:[]
  },
  getclasstype(){
    let that=this;
    wx.request({
      url: 'http://localhost:8080/class/menutype/getmenutype',
      success(res){
        that.setData({
          classtype:res.data
        })
      }
    })
  },
  getbook:function(){
    let that=this;
    wx.request({
      method: "post",
    header: {
      'content-type': 'application/x-www-form-urlencoded;charset=utf-8', // 默认值
      'cookie': wx.getStorageSync('Set-Cookie')
    },
    scriptCharset: 'utf-8',
      //无分类时遍历
      url: 'http://localhost:8080/class/menu/bymenutype',
      data:({
        classify:""
    }),
      success(res){
        let list=res.data.data
        if(list&&list.length>0){
          list.forEach(item => {
              item.num=0
              item.rank=9999
          });
        }
        that.setData({
          booklist:list
        })
      }
     
    })
    
},
listcart(){
  let that = this;
  let flag = this.data.isHiddens
  if(flag){
    that.setData({
      isHiddens: false
      })
  }else{
    that.setData({
      isHiddens: true
      })
  }
  
},
decrease(e){
  let id=e.currentTarget.dataset.sname
  let price = e.currentTarget.dataset.price
  let totalprice=this.data.totalprice
  let cartlist = this.data.cartlist
  let rank= this.data.rank
  // console.log(price)
  // console.log(id)
  let list = this.data.booklist
  list.forEach(item =>{
    if(item.id==id){
      if(item.num>0){
        item.num-=1
        cartlist.splice(item.rank,1)
        rank-=1
        totalprice=totalprice-price
      }else{
        wx.showToast({
          icon:"none",
          title: '不能再减了',
        })
      }
    }
  })
  this.setData({
    booklist: list,
    totalprice:totalprice,
    cartlist:cartlist,
    rank:rank
  })
  // console.log(this.data.cartlist)
},
increase:function(e){
  let id=e.currentTarget.dataset.sname
  let price = e.currentTarget.dataset.price
  let totalprice=this.data.totalprice
  let list = this.data.booklist
  let cartlist = this.data.cartlist
  let rank = this.data.rank 
  list.forEach(item =>{
    if(item.id==id){
      if(item.id>0){
        item.num+=1
        item.rank=rank
        rank+=1
        totalprice=totalprice+price
        cartlist.push(item)
      }else{
        wx.showToast({
          icon:"none",
          title: '不能再减了',
        })
      }
    }
  })
  this.setData({
    booklist: list,
    totalprice:totalprice,
    cartlist:cartlist,
    rank:rank
  })
  // console.log(this.data.cartlist)
},
submit1(){
  let list = this.data.booklist
  wx.request({
    method: "post",
  header: {
    'content-type': 'application/x-www-form-urlencoded;charset=utf-8', // 默认值
    'cookie': wx.getStorageSync('Set-Cookie')
  },
  scriptCharset: 'utf-8',
    //无分类时遍历
    url: 'http://localhost:8080/class/cust/submit1',
    data:({
      openid:this.data.openid,
      totalprice:this.data.totalprice,
      createtime:this.data.createday
  }),
    success(res){
      
    if(res.data==1){
      wx.showToast({
        title: '下单成功',
      })
      setTimeout(function(){
        wx.navigateTo({
          url: '../../pages/success/success',
        })
      },1000)
    }else{
      wx.showToast({
        title: '亲亲余额不足~',
      })
    }
    }
   
  })
  if(list&&list.length>0){
    list.forEach(item => {
        item.num=0
        item.rank=9999
    });
  }
 this.setData({
    booklist:list
  })
  this.setData({
    totalprice:0,
    cartlist:[]
  })
},
searchtab(e){
  var id = e.currentTarget.dataset.type;
  // console.log(id);
  let that=this;
  wx.request({
    //请求包含中文时的法宝 谁用谁说好
    method: "post",
    header: {
      'content-type': 'application/x-www-form-urlencoded;charset=utf-8', // 默认值
      'cookie': wx.getStorageSync('Set-Cookie')
    },
    scriptCharset: 'utf-8',
    //搜索按菜品分类之后的菜单
    url: 'http://localhost:8080/class/menu/bymenutype',
    data:({
      classify:id
  }),
    success(res){
      let list=res.data.data
        if(list&&list.length>0){
          list.forEach(item => {
              item.num=0
          });
        }
      that.setData({
        booklist:list
      })
      // console.log(res.data.data)
    }
  })
},
getNowTime(){//这个函数获取当前时间
  var now = new Date();
  var year = now.getFullYear();
  var month = now.getMonth() + 1;
  var day = now.getDate();
  if (month < 10) {
    month = '0' + month;
  };
  if (day < 10) {
    day = '0' + day;
  };
  //  如果需要时分秒，就放开
  var h = now.getHours();
  var m = now.getMinutes();
  var s = now.getSeconds();
  var formatDate =  year + '-' + month + '-' + day+ ' '+h+ ':'+m+ ':'+s;
  this.setData({
    createday:formatDate
  })
  // return formatDate;
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
        this.getNowTime();
        this.getclasstype();
        this.getbook();
        this.setData({
          imgurl:"../../images/mphoto/",
        })
        this.setData({
          openid:app.globalData.openid
        })
        // console.log(this.data.createday)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.getbook();
    this.setData({
      openid:app.globalData.openid
    })
  // console.log(this.data.openid)
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   * 
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})