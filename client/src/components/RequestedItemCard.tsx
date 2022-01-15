import React from "react";
import { ReactElement } from "react";
import { FC } from "react";

import { View } from "@tarojs/components";

import { IRequestedItem } from "interfaces/interfaces";

interface IProps {
  requestedItem: IRequestedItem;
}

const Requesteditemcard: FC<IProps> = ({ requestedItem }): ReactElement => {
  const { id, description, requesterId, requester } = requestedItem;
  return (
    <>
      <View>{id}</View>
      <View>{description}</View>
      <View>{requesterId}</View>
      <View>{requester.nickname}</View>
      <br />
      
    </>
  );
};

export default Requesteditemcard;
