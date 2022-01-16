import { FC, ReactElement, useEffect, useState } from "react";
import { View, Text } from "@tarojs/components";
import { axios } from "taro-axios";

import { IRequestedItem } from "interfaces/interfaces";
import RequestedItemCard from "../../components/RequestedItemCard";
import urls from "../../constants/url";
import { AtList, AtListItem, AtSwipeAction } from "taro-ui";

const path = urls.myWishlistUrl;

const Wishlist: FC = (): ReactElement => {
  const [wishlist, setWishlist] = useState<IRequestedItem[]>([]);
  useEffect(() => {
    async function fetchData() {
      const response = await axios.get(path, {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      });
      console.log(response);
      console.log(response.data);

      setWishlist(response.data);
    }
    fetchData();
  }, [path]);

  console.log(wishlist);
  const handleSingle = () => {};
  return (
    <View>
      {/* {wishlist.map((requestedItem: IRequestedItem, index: number) => {
        return (
          <RequestedItemCard
            key={requestedItem.id}
            requestedItem={requestedItem}
          />
        );
      })} */}

      <AtList>
        {wishlist.map((item, index) => (
          <AtSwipeAction
            key={index}
            autoClose = {true}
            onOpened={handleSingle}
            isOpened={false}
            options={[
              {
                text: "编辑",
                style: {
                  backgroundColor: "#6190E8",
                },
              },
              {
                text: "删除",
                style: {
                  backgroundColor: "#FF4949",
                },
              },
            ]}
          >
            <AtListItem title={item.description} />
          </AtSwipeAction>
        ))}
      </AtList>
    </View>
  );
};

export default Wishlist;
