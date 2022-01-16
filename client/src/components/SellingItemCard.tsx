import { Swiper, SwiperItem, View } from "@tarojs/components";
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
          <View>1</View>
        </SwiperItem>
        <SwiperItem>
          <View>2</View>
        </SwiperItem>
        <SwiperItem>
          <View>3</View>
        </SwiperItem>
      </Swiper>
      <View>{price}</View>
      <View>{description}</View>
      <View>{seller.nickname}</View>
    </View>
  );
};

export default SellingItemCard;
