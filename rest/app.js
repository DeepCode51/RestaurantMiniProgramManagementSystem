// app.js
App({
  globalData: {
    openid:"",
  },  
  onLaunch() {
    //云开发部署
    if (!wx.cloud) {
      console.error('请使用 2.2.3 或以上的基础库以使用云能力');
    } else {
      wx.cloud.init({
        // env 参数说明：
        //   env 参数决定接下来小程序发起的云开发调用（wx.cloud.xxx）会默认请求到哪个云环境的资源
        //   此处请填入环境 ID, 环境 ID 可打开云控制台查看
        //   如不填则使用默认环境（第一个创建的环境）
        // env: 'cloud1-0gx32eqdfc662756',
        traceUser: true,
      });
    }
    var that = this;
    this.getSystemInfo();
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    wx.cloud.callFunction({
      name: 'quickstartFunctions',
      // config: {
      //   env: this.data.envId
      // },
      data: {
        type: 'getOpenId'
      }
    }).then((resp) => {
      that.globalData.openid=resp.result.openid
      // console.log(resp.result.openid)
   })

  },
  getSystemInfo: function () {
    let t = this;
    wx.getSystemInfo({
      success: function (res) {
        t.globalData.systemInfo = res;
      }
    });
  },
  onShow: function () {
  },

})
