import { Component } from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import BoardList from "./BoardList";
import Write from "./Write";

/**
 * App class
 */

class App extends Component {
    state = {
        isModifyMode: false,
        isComplete: true,
        boardId: 0,
        isWrite:false
    };

    
    /**
     * @param {any} checkList
     */
    handleModify = (checkList: any) => {
        if (checkList.length === 0) {
            alert("수정할 게시글을 선택하세요.");
        } else if (checkList.length > 1) {
            alert("하나의 게시글만 선택하세요.");
        }

        this.setState({
            isModifyMode: checkList.length === 1,
        });

        this.setState({
            boardId: checkList[0] || 0,
        });
    };

    handleCancel = () => {
        this.setState({
            isModifyMode: false,
            isComplete: false,
            boardId: 0,
            isWrite:false
        });
    };

    renderComplete = () => {
        this.setState({
            isComplete: true,
        });
    };

    handleWrite = () => {
        this.setState({
            isWrite: true,
        });
    };

    /**
     * @return {Component} Component
     */
    render() {
        if(this.state.isModifyMode===true||this.state.isWrite===true){
            return (
            
                <div className="App">
                    <BoardList
                        isComplete={this.state.isComplete}
                        handleModify={this.handleModify}
                        renderComplete={this.renderComplete}
                        handleWrite={this.handleWrite}
                    ></BoardList>
                
                        <Write
                        isModifyMode={this.state.isModifyMode}
                        boardId={this.state.boardId}
                        handleCancel={this.handleCancel}
                    ></Write>                
                </div>
            );
        }
        else{
            return (
            
                <div className="App">
                    <BoardList
                        isComplete={this.state.isComplete}
                        handleModify={this.handleModify}
                        renderComplete={this.renderComplete}
                        handleWrite={this.handleWrite}
                    ></BoardList>                
                </div>
            );
        }
    }
}

export default App;
