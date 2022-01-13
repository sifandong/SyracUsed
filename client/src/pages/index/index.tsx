import { Component, FC, ReactElement } from "react";
import { View, Text, Button} from "@tarojs/components";
import Taro from "@tarojs/taro";
import "./index.scss";

// export default class Index extends Component {

//   componentWillMount () { }

//   componentDidMount () { }

//   componentWillUnmount () { }

//   componentDidShow () { }

//   componentDidHide () { }

//   render () {
//     return (
//       <View className='index'>
//         <Text>Hello world!</Text>
//       </View>
//     )
//   }
// }

const Index: FC = (): ReactElement => {
  function handleClick(){
    console.log('大傻逼');
    
    Taro.navigateTo({
      url: '/pages/market/index'
    }).then(response =>{
      console.log(response);
      
    })
    console.log("我服了");
    
  }
  
  return (
    <div>
      <View> 开发小程序第一步 </View>
      <Button onClick={handleClick}>去市场看看</Button>
    </div>
  );
};
export default Index;
