import { Component, FC, ReactElement, useState } from "react";
import {
  View,
  Text,
  Input,
  Radio,
  Label,
  RadioGroup,
  Form,
  Button,
} from "@tarojs/components";
import { AtForm } from "taro-ui";
import axios from "taro-axios";
import urls from "../../constants/url";

const addSellingItemPath = urls.addSellingItemUrl;
const AddSellingItem: FC = (): ReactElement => {
  const [price, setPrice] = useState<number>(-1);
  const [isDollar, setIsDollar] = useState<boolean>(true);
  const [description, setDescription] = useState<string>("");
  const [isDeliverable, setIsDeliverable] = useState<boolean>(false);

  const handleSubmit = (e)=>{
    axios.post(addSellingItemPath,{
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
      price: price,
      isDollar: isDollar,
      description: description,
      isDeliverable: isDeliverable,
      sellerId: 5
    })
    .then(response =>{
      console.log(response.data);
      
    })
    .catch(error =>{
      console.log(error);
      
    })
    
  }
  const handleReset = (e)=>{
    console.log(e.detail);
    
  }
  return (
    <View>
      <Form onSubmit = {handleSubmit} onReset={handleReset}>
        <View>
          <Input
            type="number"
            placeholder="请输入金额"
            onInput={(e): void => {
              setPrice(Number(e.detail.value));
            }}
          />
        </View>
        <View>
          <RadioGroup
            onChange={(e) => {
              console.log(e.detail);
              setIsDollar(!isDollar);
            }}
          >
            <Label>
              <View>
                <Radio value="dollar" checked>
                  美元
                </Radio>
              </View>
            </Label>
            <Label>
              <View>
                <Radio value="rmb">人民币</Radio>
              </View>
            </Label>
          </RadioGroup>
        </View>
        <View>
          <Input
            type="text"
            placeholder="请添加描述"
            onInput={(e): void => {
              setDescription(e.detail.value);
            }}
          />
        </View>
        <View>
          <RadioGroup onChange={(e)=>{
            setIsDeliverable(!isDeliverable)
          }}>
            <Label>
              <View>
                <Radio value="non-deliverable" checked>上门自取</Radio>
              </View>
            </Label>
            <Label>
              <View>
                <Radio value="devliverable" >
                  可送货
                </Radio>
              </View>
            </Label>
            
          </RadioGroup>
        </View>
        <Button formType = 'submit'>提交</Button>
      </Form>
    </View>
  );
};

export default AddSellingItem;
