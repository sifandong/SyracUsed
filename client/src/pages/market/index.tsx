import { FC, ReactElement, useEffect, useState } from "react";
import { View, Text } from "@tarojs/components";
import "./index.scss";
import { ISellingItem } from "interfaces/interfaces";
import axios from "taro-axios";
import urls from "../../constants/url";
import SellingItemCard from "../../components/SellingItemCard";

const path = urls.allSellingItemsUrl;
const Market: FC = (): ReactElement => {
  const [sellingItems, setSellingItems] = useState<ISellingItem[]>([]);

  useEffect(() => {
    async function fetchData() {
      const response = await axios.get(path, {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      });
      console.log(response);
      console.log(response.data);
      setSellingItems(response.data);
    }
    fetchData();
  }, [path]);

  console.log(sellingItems);

  return (
    <View>
      <View className="at-row at-row--wrap">
        {sellingItems.map((sellingItem: ISellingItem, index: number) => {
          return (
            <View className="at-col at-col-6">
              <SellingItemCard key={sellingItem.id} sellingItem={sellingItem} />
            </View>
          );
        })}
      </View>
    </View>
  );
};

export default Market;
