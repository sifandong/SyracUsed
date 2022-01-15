const devUrl:string = "http://localhost:8080/api";
// const deployUrl:string = ""
// const serverUrl:string = devUrl;

const urls = {
    deployUrl: "",
    devUrl: "http://localhost:8080/api",
    wishlistUrl: devUrl + "/requestedItems",
    mySellingItemsUrl: devUrl + "user/sellingItems/6",  // 6 is the id for the test
    myWishlistUrl: devUrl + "/user/requestedItems/2"    // 2 is the id for the test
}


export default urls;