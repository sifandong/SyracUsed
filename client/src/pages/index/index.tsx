import { Component, FC, ReactElement, useState } from "react";
import { View, Text, Button } from "@tarojs/components";
import Taro from "@tarojs/taro";
import "./index.scss";
import { AtTabBar } from "taro-ui";

const Index: FC = (): ReactElement => {
  const handleClickWishlist = () => {
    Taro.navigateTo({
      url: "/pages/packageA/pages/wishlist/index",
    })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleClickSellingItems = () => {
    Taro.navigateTo({
      url: "/pages/packageA/pages/myItems/index",
    })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleClickTest = () => {
    Taro.navigateTo({
      url: "/pages/test/index",
    })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  //

  return (
    <View>
      <View> 个人信息还没有完善 </View>
      <Button onClick={handleClickWishlist}>我的心愿单</Button>
      <Button onClick={handleClickSellingItems}>我的商品</Button>
      <Button onClick={handleClickTest}>测试</Button>
    </View>
  );
};
export default Index;
