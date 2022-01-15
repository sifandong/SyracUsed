// import { Component } from 'react'
// import './app.scss'
// import 'taro-ui/dist/style/index.scss'

// class App extends Component {

  

//   componentDidMount () {}

//   componentDidShow () {}

//   componentDidHide () {}

//   componentDidCatchError () {}

//   // this.props.children 是将要会渲染的页面
//   render () {
//     return this.props.children
//   }
// }

// export default App

import React, { useEffect } from "react";
import 'taro-ui/dist/style/index.scss'
// Taro 额外添加的 hooks 要从 '@tarojs/taro' 中引入
import { useDidShow, useDidHide } from "@tarojs/taro";

// 全局样式
import "./app.scss";

function App(props) {
  // 可以使用所有的 React Hooks
  useEffect(() => {});

  // 对应 onShow
  useDidShow(() => {});

  // 对应 onHide
  useDidHide(() => {});

  return (
    // 在入口组件不会渲染任何内容，但我们可以在这里做类似于状态管理的事情
    //设置请放置在app.congif.ts文件中！！！

    props.children
  );
}

export default App;
