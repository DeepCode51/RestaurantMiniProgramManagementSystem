// pages/aboutme/aboutme.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
      tabbar:{},
      userInfo: {},
      cust:[],
      hasUserInfo: false,
      canIUse: wx.canIUse('button.open-type.getUserInfo'),
      canIUseGetUserProfile: false,
      openid:"",
      money:0,
      canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName') // 如需尝试获取用户信息可改为false
      // canIUseOpenData:false
  },
getinfo(){
  var that=this
  // let openid=this.data.openid
  wx.request({
    url: 'http://localhost:8080/class/cust/getinfo',
      data:({
        openid:this.data.openid
      }),
      success(res){
        that.setData({
          money:res.data
        })
      },
  })
 
},
getmoney(){
  let cust = this.data.cust
  // console.log(cust)
  let money=0
  if(cust&&cust.length>0){
    cust.forEach(item => {
         money=item.money
         console.log(item.money)
        item.rank=9999
    });
  }
  this.setData({
    money:money
  })
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
   
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
    this.setData({
      openid:app.globalData.openid
    })
    // console.log(this.data.openid)
    this.getinfo();
    // console.log(this.data.cust)
   this.getmoney();
  },
  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        // console.log(res)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
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
    this.getinfo();
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
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})