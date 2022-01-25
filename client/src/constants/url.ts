const devUrl:string = "http://localhost:8080/api";
const deployUrl:string = ""
const serverUrl:string = devUrl;

const urls = {
    deployUrl: "",
    devUrl: "http://localhost:8080/api",
    wishlistUrl: serverUrl + "/requestedItems",
    mySellingItemsUrl: serverUrl + "/user/sellingItems/6",  // 6 is the id for the test
    myWishlistUrl: serverUrl + "/user/requestedItems/2",    // 2 is the id for the test
    addWishlistItemUrl: serverUrl + "/requestedItem",
    allSellingItemsUrl: serverUrl + "/sellingItems",
    sellingItemDetailUrl: serverUrl+"/sellingItem",
    addSellingItemUrl: serverUrl + "/sellingItem",
    uploadImagesUrl: serverUrl + "/uploadImages",
}


export default urls;