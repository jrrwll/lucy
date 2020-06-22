import React, {useEffect, useState} from "react";

import './HomePage.css'
import {Breadcrumb, Layout} from 'antd';
import HeadArea from "../common/HeadArea";
import {FormattedMessage} from "react-intl";

const {Content, Footer} = Layout;

export default function HomePage() {
    const [ipinfo, setIpinfo] = useState({});

    useEffect(() => {

    }, []);

    return (<>
        <Layout className="layout">
            <HeadArea/>
            <Content style={{padding: '0 50px'}}>
                <Breadcrumb style={{margin: '16px 0'}} separator='-'>
                    <Breadcrumb.Item>
                        <FormattedMessage id="home.ip.ip_query"/>
                    </Breadcrumb.Item>
                    <Breadcrumb.Item>
                        <FormattedMessage id="home.ip.your_ip"/>
                    </Breadcrumb.Item>
                    <Breadcrumb.Item>
                        <a href={ipinfo.ip ? `/${ipinfo.ip}` : '#'} style={{color: 'blue'}}>
                            {ipinfo.ip ? ipinfo.ip :
                                <FormattedMessage id="home.ip.unknown"/>}
                        </a>
                    </Breadcrumb.Item>
                    <Breadcrumb.Item>
                        <FormattedMessage id="home.ip.from"/>
                    </Breadcrumb.Item>
                    <Breadcrumb.Item style={{color: 'blue'}}>
                        {ipinfo.location ? ipinfo.location :
                            <FormattedMessage id="home.ip.unknown"/>}
                    </Breadcrumb.Item>
                </Breadcrumb>
                <div className="site-layout-content">

                </div>
            </Content>
            <Footer style={{textAlign: 'center'}}>Lucy Web Tools ©2020 Powered by Ant-Design</Footer>
        </Layout>
    </>);
}
