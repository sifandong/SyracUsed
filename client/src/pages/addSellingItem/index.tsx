import { Component, FC, ReactElement, useCallback, useEffect, useState } from "react";
import {
  View,
  Text,
  Input,
  Radio,
  Label,
  RadioGroup,
  Form,
  Button,
  Image
} from "@tarojs/components";
import { AtForm } from "taro-ui";
import axios, {PostData, FileData} from "taro-axios";
import urls from "../../constants/url";
import UploadImages from "../../components/UploadImages";
import { IFile } from "interfaces/interfaces";
import Taro from "@tarojs/taro";

const addSellingItemPath = urls.addSellingItemUrl;
const uploadImagesPath = urls.uploadImagesUrl;
const updateImagePath = urls.updateImageUrl;
const AddSellingItem: FC = (): ReactElement => {
  const [price, setPrice] = useState<number>(-1);
  const [isDollar, setIsDollar] = useState<boolean>(true);
  const [description, setDescription] = useState<string>("");
  const [isDeliverable, setIsDeliverable] = useState<boolean>(false);
  const [filesUrls, setFilesUrls] = useState<IFile[]>([] as IFile[]);
  const [imageIds, setImageIds] = useState<number[]>([]);


  const [test, setTest] = useState()
  useEffect(()=>{
    console.log(filesUrls);
    console.log('raspberryberry');
    if(filesUrls.length > 0){
      let inter = filesUrls[0].url.split('/');
      console.log(inter);
      let target = inter[inter.length -1 ].split('.')
      console.log(target);
      
    }
    
  },[filesUrls]);
  const handleSubmit = (e)=>{
    console.log(filesUrls);
    console.log('raspberryberry');
    axios.post(addSellingItemPath,{
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
      price: price,
      isDollar: isDollar,
      description: description,
      isDeliverable: isDeliverable,
      sellerId: 1
    })
    .then(response =>{
      console.log(response.data);
      console.log(response.data.id);
      const itemId = response.data.id;
      imageIds.forEach(imageId=>{
        const path = urls.updateImageUrl + `?imageId=${imageId}&itemId=${itemId}`
        axios.put(path,{
          headers: {
            "Access-Control-Allow-Origin": "*",
          },
        }).then(res=>{
          console.log(res);
          
        }).catch(err=>{
          console.log(err);
          
        })
      })
      
    })
    .catch(error =>{
      console.log(error);
      
    })
    
  }
  const handleReset = (e)=>{
    console.log(e.detail);
    
  }
  const setImages = useCallback((fs:IFile[])=>{
    // console.log(file);
    
      setFilesUrls(filesUrls => [...fs]);
  },[])
  const handleClick = async ()=>{
    filesUrls.forEach(fileUrl =>{
      Taro.uploadFile({
        url:"http://localhost:8080/api/uploadImages",
        header:{
          'content-type': 'multipart/form-data'
        },
        name:'file',
        formData:{
          'uploaderId': 1
        },
        filePath:fileUrl.url,
        success: (res)=>{
          console.log(res.data);
          let json_res = JSON.parse(res.data);
          console.log(json_res.id);
          setImageIds(imageIds => [...imageIds,json_res.id]);
        }
      })
    })
   
    
  }
  // function process(filesUrls,formData){
    
  //   filesUrls.array.forEach(async (element) => {
  //     let name = obtainName(element);
  //     let imgBlob = await fetch(element.url).then(r => r.blob());
  //     let imgFile = new File([imgBlob],name,{
  //       type: imgBlob.type
  //     })
  //     const reader = new FileReader();
  //     reader.readAsDataURL(imgBlob);
  //     console.log('gggggggggggggggggggggggggg');
      
  //     formData.append('file',imgFile)
      
  //   });
  // }
  // function obtainName(element){
  //     let inter = element.url.split('/');
  //     console.log(inter);
  //     let target = inter[inter.length -1 ].split('.')
  //     console.log(target);
  //     return target[0]
  // }
  
  
  return (
    <View>
      
      <UploadImages 
        filesUrls = {filesUrls}
        setImages={setImages}
        
      />
      
      {filesUrls.length > 0 && <Button onClick={handleClick}>提交图片</Button>}
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
      {/* <View>
        { files.length > 0 && <Image 
          src={files[0].url}
        />}
      </View> */}
    </View>
  );
};

export default AddSellingItem;
