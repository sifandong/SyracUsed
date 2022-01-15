import React from "react";
import { ReactElement } from "react";
import { FC } from "react";
import { AtCard } from "taro-ui";
import { View } from "@tarojs/components";
// @import "~taro-ui/dist/style/components/card.scss";
import { IRequestedItem } from "interfaces/interfaces";

interface IProps {
  requestedItem: IRequestedItem;
}

const RequestedItemCard: FC<IProps> = ({ requestedItem }): ReactElement => {
  const { id, description, requesterId, requester } = requestedItem;
  return (
    <>
      {/* <View>{id}</View>
      <View>{description}</View>
      <View>{requesterId}</View>
      <View>{requester.nickname}</View> */}
      <AtCard
        note="reserved"
        extra="reserved"
        title={requester.nickname}
        
      >
        {description}
      </AtCard>
     
      
    </>
  );
};

export default RequestedItemCard;
