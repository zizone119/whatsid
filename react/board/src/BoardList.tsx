import  Axios from "axios";
import { Component } from "react";
import  Button  from "react-bootstrap/Button";
import Table from "react-bootstrap/Table";

const Board = ({
    id,
    title,
    registerId,
    registerDate,
    updateDate,
    props
}: {
    id: number,
    title: string,
    registerId: string,
    registerDate: string,
    updateDate:string,
    props:any
}) => {
    return (
        <tr>
            <td>
                <input 
                    type="checkbox"
                    value={id}
                    onChange={(e)=>{
                        props.onCheckboxChange(e.currentTarget.checked,e.currentTarget.value);
                    }}
                ></input>
            </td>
            <td>{id}</td>
            <td>{title}</td>
            <td>{registerId}</td>
            <td>{registerDate}</td>
            <td>{updateDate}</td>
        </tr>
    );
};
interface IProps{
    isComplete: boolean,
    handleModify: any,
    renderComplete: any,
    handleWrite:any
}
class BoardList extends Component<IProps> {

    constructor(props:any){
        super(props);
        this.state={
            boardList:[],
            checkList:[]
        };
    }

    state={
        boardList:[],
        checkList:[]
    };

    getList = ()=>{
        Axios.get('http://localhost:8000/list',{}).then((res)=>{
            const {data}=res;
            console.log(data);
            this.setState({
                boardList:data
            })
        })
        .catch((e)=>{
            console.error(e);
        })
    }
    
    onCheckboxChange=(checked:boolean, id:any)=>{
        const list:Array<string> = this.state.checkList.filter((v)=>{
            return v!==id;
        })
        if(checked){
            list.push(id);
        }
        this.setState({
            checkList:list,
        })
    }
    componentDidMount(){
        this.getList();
    }
    componentDidUpdate(){
        if(!this.props.isComplete){
            this.getList();
        }
    }
    handleDelete=()=>{
        if(this.state.checkList.length===0){
            alert('삭제할 게시글을 선택하세요.');
            return;
        }
        let boardList='';
        this.state.checkList.forEach((v:any)=>{
            boardList+=`'${v}',`;

        })
        Axios.post('http://localhost:8000/delete',{
            boardList: boardList.substring(0,boardList.length-1),
        }).then(()=>{
            this.setState({
                checkList:[]
            })
            this.getList();
        }).catch(e=>{
            console.log(e);
        })
    }
    render() {
        const {boardList}:{boardList:any}=this.state;
        return (
            <>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>선택</th>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>수정일</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        boardList.map((v:any)=>{
                            return(
                                <Board
                                    id={v.board_id}
                                    title={v.board_title}
                                    registerId={v.register_id}
                                    registerDate={v.register_date}
                                    updateDate={v.updater_date}
                                    key={v.board_id}
                                    props={this}
                                />
                            )
                        })
                    }
                </tbody>
            </Table>
            <div>
                <Button  variant='info' onClick={()=>{this.props.handleWrite()}}>글쓰기</Button>
                <Button  style={{marginLeft:5}} variant="secondary" onClick={()=>{
                    this.props.handleModify(this.state.checkList);
                }}>수정하기</Button>
                <Button style={{marginLeft:5}} variant="danger" onClick={this.handleDelete}>삭제하기</Button>
                <br></br>
                <br></br>
            </div>
            </>
        );
    }
}

export default BoardList;
