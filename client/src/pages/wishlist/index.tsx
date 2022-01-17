import { FC, ReactElement, useCallback, useEffect, useState } from "react";
import { View, Text, Button, Input } from "@tarojs/components";
import { axios } from "taro-axios";

import { IRequestedItem } from "interfaces/interfaces";

import urls from "../../constants/url";
import { AtList, AtListItem, AtSwipeAction } from "taro-ui";

import AddWishlistItem from "../../components/AddWishlistItem";

const fetchWishlistPath = urls.myWishlistUrl;
const addWishlistItemPath = urls.addWishlistItemUrl;

const Wishlist: FC = (): ReactElement => {
  const [wishlist, setWishlist] = useState<IRequestedItem[]>([]);
  const [hide, setHide] = useState<boolean>(true);

  const addWishlist = useCallback((requestedItem: IRequestedItem) => {
    setWishlist((wishlist) => [...wishlist, requestedItem]);
  }, []);

  useEffect(() => {
    async function fetchData() {
      const response = await axios.get(fetchWishlistPath, {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      });
      console.log(response);
      console.log(response.data);

      setWishlist(response.data);
    }
    fetchData();
  }, [fetchWishlistPath]);

  const handleClickAdd = () => {
    setHide(!hide);
  };

  console.log(wishlist);
  const handleSingle = () => {};
  return (
    <View>
      <View>
        <Button onClick={handleClickAdd}>添加</Button>
        {!hide && <AddWishlistItem addWishlist={addWishlist} />}
      </View>

      <AtList>
        {wishlist.map((item, index) => (
          <AtSwipeAction
            key={index}
            autoClose={true}
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
