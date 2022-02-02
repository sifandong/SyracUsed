import { FC, ReactElement, useEffect, useState } from "react";
import { View, Text } from "@tarojs/components";
import { axios } from "taro-axios";

import { IRequestedItem } from "interfaces/interfaces";
import RequestedItemCard from "../../components/RequestedItemCard";
import urls from "../../constants/url";
import { AtTabBar } from "taro-ui";
import Taro from "@tarojs/taro";

const path = urls.wishlistUrl;

const Hunt: FC = (): ReactElement => {
  const [requestedItems, setRequestedItems] = useState<IRequestedItem[]>([]);

  useEffect(() => {
    async function fetchData() {
      const response = await axios.get(path, {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      });
      console.log(response);
      console.log(response.data);

      setRequestedItems(response.data);
    }
    fetchData();
  }, [path]);

  console.log(requestedItems);

  return (
    <View>
      {requestedItems.map((requestedItem: IRequestedItem, index: number) => {
        return (
          <RequestedItemCard
            key={requestedItem.id}
            requestedItem={requestedItem}
          />
        );
      })}
    </View>
  );
};

export default Hunt;
