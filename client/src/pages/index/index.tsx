import { Component, FC, ReactElement } from "react";
import { View, Text, Button} from "@tarojs/components";
import Taro from "@tarojs/taro";
import "./index.scss";



const Index: FC = (): ReactElement => {
  
  const handleClickMarket = ()=>{
    Taro.navigateTo({
      url: '/pages/market/index'
    }).then(response =>{
      console.log(response);
      
    })
  }
  const handleClickWishlist = ()=>{
    Taro.navigateTo({
      url: '/pages/wishlist/index'
    }).then(response =>{
      console.log(response);
      
    })
  }
  const handleClickMyItems = ()=>{
    Taro.navigateTo({
      url: '/pages/addSellingItem/index'
    }).then(response =>{
      console.log(response);
      
    })
  }
  const handleClickHunt = ()=>{
    Taro.navigateTo({
      url: '/pages/hunt/index'
    }).then(response =>{
      console.log(response);
      
    })
  }
  const handleClickTest = ()=>{
    Taro.navigateTo({
      url: '/pages/test/index'
    }).then(response =>{
      console.log(response);
      
    })
  }
  return (
    <View>
      <View> 开发小程序第一步 </View>
      <Button onClick={handleClickMarket}>去市场看看</Button>
      <Button onClick = {handleClickWishlist}>愿望单</Button>
      <Button onClick = {handleClickMyItems}>我的物品</Button>
      <Button onClick = {handleClickHunt}>求购</Button>
      <Button onClick = {handleClickTest}>测试</Button>
    </View>
  );
};
export default Index;
