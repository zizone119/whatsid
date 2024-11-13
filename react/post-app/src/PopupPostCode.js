import DaumPostcode from "react-daum-postcode";

const PopupPostCode = (props) => {
  const handlePostCode = (data) => {
    let fullAddress = data.address;
    let extraAddress = "";
    if (data.addressType === "R") {
      if (data.bname !== "") {
        extraAddress += data.bname;
      }
      if (data.buildingName !== "") {
        extraAddress +=
          extraAddress !== "" ? `, ${data.buildingName}` : data.buildingName;
      }
      fullAddress += extraAddress !== "" ? `(${extraAddress})` : "";
    }
    console.log(data);
    console.log(fullAddress);
    console.log(data.zonecode);
  };
  const postCodeStyle={
    display:'block',
    top:"10%",
    width:'600px',
    height:'600px',
    padding: '7px'
  }
  return(
    <div>
        <DaumPostcode style={postCodeStyle} onComplete={handlePostCode}></DaumPostcode>
        <button type='button' onClick={()=>{props.onClose()}} className="postCode-btn">닫기</button>
    </div>
  )
};

export default PopupPostCode;
