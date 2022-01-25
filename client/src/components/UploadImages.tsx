import React, { FC, ReactElement, useState } from "react";
import Taro from "@tarojs/taro";
import { Button, View } from "@tarojs/components";

import { IFile } from "interfaces/interfaces";
import AtImagePicker from "taro-ui/lib/components/image-picker";

interface IProps {
  filesUrls: IFile[];
  setImages: (fs: IFile[]) => void;
}

const UploadImages: FC<IProps> = ({ filesUrls, setImages }): ReactElement => {
  const [showButton, setShowButton] = useState<boolean>(true);

  const handleChange = (currentFiles) => {
      if(currentFiles.length > 3){
          setShowButton(false);
      }else{
          setShowButton(true);
      }
    // setCurrent(currentFiles);
    setImages(currentFiles);
    console.log(currentFiles);
    console.log('dsf');
    
    
  };
  const handleFail = (msg) => {
    console.log(msg);
  };

  const handleClick = (index, file) => {
    console.log(index);
    console.log(file);
  };
  return (
    <>
      <AtImagePicker
        length={2}
        showAddBtn={showButton}
        
        files = {filesUrls}
        onChange={handleChange}
        onFail={handleFail}
        onImageClick={handleClick}
      />
    </>
  );
};

export default UploadImages;
