import { User as UserType } from 'firebase/auth';

export type User = UserType | null;

export type Media = {
    id: string;
    title: string;
    source: string;
    sourceId: string;
    description: string;
    poster: string;
    type: string;
    seasons: Seasons[];
};

type Seasons = {
    id: string;
    title: string;
    source: string;
    sourceId: string;
    seasonNumber: number;
    episodeCount: number;
};
