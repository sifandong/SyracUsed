import { FC, ReactElement, useEffect, useState } from "react";
import { View, Text } from "@tarojs/components";
import { axios } from "taro-axios";

import { IRequestedItem } from "interfaces/interfaces";
import RequestedItemCard from "../../components/RequestedItemCard";
import urls from "../../constants/url";

const path = urls.myWishlistUrl

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

  return (
    <View>
      {wishlist.map((requestedItem: IRequestedItem, index: number) => {
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

export default Wishlist;
