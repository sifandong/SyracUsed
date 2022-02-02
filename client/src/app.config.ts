export default {
  pages: [
    'pages/index/index',
    'pages/hunt/index',
    'pages/market/index',
    // 'pages/wishlist/index',
    // 'pages/myItems/index',
    // 'pages/sellingItemDetail/index',
    // 'pages/addSellingItem/index',
    'pages/test/index'

  ],
  window: {
    backgroundTextStyle: 'light',
    navigationBarBackgroundColor: '#fff',
    navigationBarTitleText: 'WeChat',
    navigationBarTextStyle: 'black'
  },
  
  tabBar: {
    list: [
      {
        pagePath:'pages/index/index',
        text:'我的'
      },
      {
        pagePath:'pages/market/index',
        text:'市场'
      },
      {
        pagePath:'pages/hunt/index',
        text:'寻物'
      }
    ]
  },
  subpackages:[
    {
      root: 'pages/packageA',
      pages:[
        'pages/addSellingItem/index',
        'pages/myItems/index',
        'pages/sellingItemDetail/index',
        'pages/wishlist/index'
      ]
    }
  ]
}
