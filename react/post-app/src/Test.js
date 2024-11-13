import { useState } from 'react';
import PopupDom from './PopupDom';
import PopupPostCode from './PopupPostCode';

const Test=()=>{
    const [ isPopupOpen, setIsPopopOpen] = useState(false);
    const openPostCode=()=>{
        setIsPopopOpen(true);
    }
    const closePostCode=()=>{
        setIsPopopOpen(false);
    }
    return(
        <div>
            <button type='button' onClick={openPostCode}>
                우편번호검색
            </button>
            <div id='popupDom'>
                {isPopupOpen&&(
                    <PopupDom>
                        <PopupPostCode onClose={closePostCode}>

                        </PopupPostCode>
                    </PopupDom>
                )}
            </div>
        </div>
    )
}

export default Test;