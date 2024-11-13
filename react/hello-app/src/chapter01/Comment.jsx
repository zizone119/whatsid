import React from "react";

const styles={
    wrapper:{
        margin: 8,
        padding: 8,
        display : 'flex',
        flexDirection : 'row',
        border : '1px solid grey',
        borderRadius: 16
    },
    imageContainer:{},
    image:{
        width:50,
        height:50,
        borderRadius: 25
    },
    contentContainer:{
        marginleft:8,
        display:'flex',
        flexDirection:'column',
        justfyContent:'center'
    },
    nameText:{
        color:'block',
        fontSize:16,
        fontWeight:'bold',
        marginLeft: 10
    },
    commentText:{
        color:'block',
        fontSize:16,
        marginLeft: 10
    }
}

function Comment(props){
    return (
        <div style={styles.wrapper}>
            <div style={styles.imageContainer}>
                <img
                src='https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png'
                style={styles.image}/>
            </div>

            <div style={styles.contentContainer}>
                <span style={styles.nameText}> {props.name}</span>
                <span style={styles.commentText}> {props.comment}</span>
            </div>
        </div>
    )
}

export default Comment;