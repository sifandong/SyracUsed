import { Swiper, SwiperItem, View, Image } from "@tarojs/components";
import React, { FC, ReactElement } from "react";

import { ISellingItem } from "interfaces/interfaces";

interface IProps {
  sellingItem: ISellingItem;
}

const SellingItemCard: FC<IProps> = ({ sellingItem }): ReactElement => {
  const { id, price, isDollar, description, isDeliverable, sellerId, seller } =
    sellingItem;
  return (
    <View>
      <Swiper
        className="test-h"
        indicatorColor="#999"
        indicatorActiveColor="#333"
        vertical
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
      <View>{price} {isDollar && '$'} {!isDollar && 'rmb'}</View>
      <View>{description}</View>
      
    </View>
  );
};

export default SellingItemCard;
