import React from "react";
import Comment from "./Comment";
function CommentList(){
    return(
        <div>
            <Comment name='정진용' comment='블록체인 학생입니다.'/>
            <Comment name='BTS' comment='세계적인 가수입니다.'/>
        </div>
    )
}

export default CommentList;