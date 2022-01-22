export interface IUser {
  id: number;
  nickname: string;
  lat: number;
  lng: number;
}

export interface IRequestedItem {
  id: number;
  description: string;
  requesterId: number;
  requester: IUser;
}

export interface ISellingItem {
  id: number;
  price: number;
  isDollar: boolean;
  description: string;
  isDeliverable: boolean;
  sellerId: number;
  seller: IUser;
}

export interface IRequestedItems {
    requestedItemList: IRequestedItem[]
}

export interface ISellingItems {
    sellingItemList: ISellingItem[]
}

export interface IFile {
  url: string;
  id: number
}

// export interface IFiles {
//   files: IFile[]
// }