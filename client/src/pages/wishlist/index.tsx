import { FC, ReactElement, useEffect, useState } from "react";
import { View, Text } from "@tarojs/components";
import { axios } from "taro-axios";

import { IRequestedItem } from "interfaces/interfaces";
import Requesteditemcard from "../../components/RequestedItemCard";

const serverUrl = "http://localhost:8080/api";

const Wishlist: FC = (): ReactElement => {
  const [requestedItems, setRequestedItems] = useState<IRequestedItem[]>([]);
  useEffect(() => {
    async function fetchData() {
      const response = await axios.get(serverUrl + "/requestedItems", {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      });
      console.log(response);
      console.log(response.data);

      setRequestedItems(response.data);
    }
    fetchData();
  }, [serverUrl]);
  console.log("asd");

  console.log(requestedItems);
  console.log(requestedItems.length);

  return (
    <View>
      {requestedItems.map((requestedItem: IRequestedItem, index: number) => {
        return (
          <Requesteditemcard
            key={requestedItem.id}
            requestedItem={requestedItem}
          />
        );
      })}
    </View>
  );
};

export default Wishlist;
