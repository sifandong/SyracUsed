import { Component, FC, ReactElement, useEffect, useState } from 'react'
import { View, Text, Swiper, SwiperItem, Image} from '@tarojs/components'
import { ISellingItem } from 'interfaces/interfaces'
import urls from '../../constants/url'
import { useRouter } from '@tarojs/taro'
import axios from 'taro-axios'

const SellingItemDetail:FC = (): ReactElement=>{
  const router = useRouter();
  const [sellingItem, SetSellingItem] = useState<ISellingItem>({} as ISellingItem);
  const {params} = router;
  const path = urls.sellingItemDetailUrl + `?id=${params.id}`
  useEffect(()=>{
    async function fetchData(){
      const response = await axios.get(path,{
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      })
      console.log(response);
      console.log(response.data);
      
      SetSellingItem(response.data)
    }
    fetchData();
    // const {id,price, description, isDollar,isDeliverable} = sellingItem;
  },[])
  return (
    <View>
      <Swiper
        className="test-h"
        indicatorColor="#999"
        indicatorActiveColor="#333"
        
        circular
        indicatorDots
        autoplay
      >
        <SwiperItem>
          <View> <Image src={require('../../../tem_images/2.jpg')}/> </View>
        </SwiperItem>
        <SwiperItem>
          <View> <Image src={require('../../../tem_images/4.jpg')}/> </View>
        </SwiperItem>
        <SwiperItem>
          <View> <Image src={require('../../../tem_images/1.jpg')}  /> </View>
        </SwiperItem>
      </Swiper>
      <View>{sellingItem.price} {sellingItem.isDollar && '美元'} {!sellingItem.isDollar && '人民币'}</View>
      <View>{sellingItem.description}</View>
      <View>{sellingItem.isDeliverable && '可送货'} {!sellingItem.isDeliverable && '上门自取'}</View>
      <View>卖家: {sellingItem.sellerId}</View>
      <View>卖家联系方式</View>
    </View>
  )
}
 export default SellingItemDetail;