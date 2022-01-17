import React, { FC, ReactElement, useState } from "react";
import { Button, Input, View } from "@tarojs/components";
import { IRequestedItem } from "interfaces/interfaces";
import axios from "taro-axios";
import urls from "../constants/url";

interface IProps {
  addWishlist: (requestedItem: IRequestedItem) => void;
}

const addWishlistItemPath = urls.addWishlistItemUrl;

const AddWishlistItem: FC<IProps> = ({ addWishlist }): ReactElement => {
  const [description, setDescription] = useState<string>("");

  const addItem = (): void => {
    function postData(description) {
      axios
        .post(addWishlistItemPath, {
          description: description,
          requesterId: 2,
        })
        .then((response) => {
          console.log(response);
          addWishlist(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    }
    postData(description);
    setDescription("");
  };

  return (
    <>
      <View>
        <Input
          type="text"
          placeholder="请添加您想收购的物品"
          onInput={(e): void => {
            setDescription(e.detail.value);
            console.log(e.detail.value);
          }}
        />
        <View>
          <Button onClick={addItem}>提交</Button>
        </View>
      </View>
    </>
  );
};

export default AddWishlistItem;
