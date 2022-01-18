import { Swiper, SwiperItem, View, Image } from "@tarojs/components";
import React, { FC, ReactElement } from "react";

import { ISellingItem } from "interfaces/interfaces";
import Taro from "@tarojs/taro";

interface IProps {
  sellingItem: ISellingItem;
}

const SellingItemCard: FC<IProps> = ({ sellingItem }): ReactElement => {
  const { id, price, isDollar, description, isDeliverable, sellerId, seller } =
    sellingItem;
  const handleClickDetail = ()=>{
    Taro.navigateTo({
      url: `/pages/sellingItemDetail/index?id=${id}`,
    })
  }
  return (
    <View>
      <Swiper
        className="test-h"
        indicatorColor="#999"
        indicatorActiveColor="#333"
        circular
        indicatorDots
        autoplay
      >
        <SwiperItem>
          <View> <Image src={require('../../tem_images/2.jpg')}/> </View>
        </SwiperItem>
        <SwiperItem>
          <View> <Image src={require('../../tem_images/4.jpg')}/> </View>
        </SwiperItem>
        <SwiperItem>
          <View> <Image src={require('../../tem_images/1.jpg')}  /> </View>
        </SwiperItem>
      </Swiper>
      <View>{price} {isDollar && '美元'} {!isDollar && '人民币'}</View>
      {/* 这里要换成title，但是数据库和后端还没改 */}
      <View>{description}</View> 
      
      <View onClick = {handleClickDetail}>详情</View>
    </View>
  );
};

export default SellingItemCard;
